package com.lucaspowered.base_physics_simulation

import com.raylib.Jaylib.*
import com.raylib.Raylib.Color

typealias Bounds = com.raylib.Jaylib.Rectangle

class World(private val name: String,
            var color: Color = RAYWHITE,
            private val resolution: Array<Int> = arrayOf(400, 400),
            private val targetFps: Int = 60
            ) {

    // shapes list. List of shapes in the world
    var shapes = mutableListOf<Shape>()

    // get world width and height
    val width: Int
        get() = resolution[0]
    val height: Int
        get() = resolution[1]

    var debug: Boolean = false

    fun run() {
        InitWindow(resolution[0], resolution[1], name)
        SetTargetFPS(targetFps)

        while (!WindowShouldClose()) {
            // update loop
            ClearBackground(color)
            BeginDrawing()

            if (debug) {
                DrawFPS(0, 0)
            }

            val time = GetTime()
            for (shape in shapes){

                // draw hitboxes
                if (debug) {
                    DrawRectangle(shape.bounds.x().toInt(), shape.bounds.y().toInt(), shape.bounds.width().toInt(),
                        shape.bounds.height().toInt(), ORANGE)
                }

                /* in theory this works because it runs this for every shape. this checks if another shape is colliding
                 with the current shape and if so, runs its doCollision method.  */

                for (oshape in otherShapes(shape)){
                    if (CheckCollisionRecs(oshape.bounds, shape.bounds)){
                        oshape.doCollision()
                    }
                }

                shape.draw(time)
            }

            EndDrawing()
        }

        CloseWindow()
    }

    // use += or .add to add a shape to the world

    operator fun plusAssign(s: Shape){
        shapes += s
    }

    fun add(s: Shape){
        plusAssign(s)
    }

    // get other shapes from shapes list
    private fun otherShapes(s: Shape): Array<Shape> {

        // shallow copy
        val t = shapes.toMutableList()
        t.remove(s)
        return t.toTypedArray()
    }
}