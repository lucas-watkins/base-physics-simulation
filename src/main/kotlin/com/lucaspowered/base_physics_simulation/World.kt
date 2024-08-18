package com.lucaspowered.base_physics_simulation

import com.raylib.Jaylib.*
import com.raylib.Raylib.Color
import com.lucaspowered.base_physics_simulation.shapes.Shape

typealias Bounds = Rectangle

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

    private val time = Time()

    fun run() {

        InitWindow(resolution[0], resolution[1], name)
        SetTargetFPS(targetFps)

        while (!WindowShouldClose()) {
            // update loop
            ClearBackground(color)
            BeginDrawing()

            // f3 to toggle debug, just like Minecraft
            if (IsKeyPressed(KEY_F3)){
                debug = !debug
            }

            // r key to reset time
            if (IsKeyPressed(KEY_R)){
                time.reset()
            }

            // right arrow to skip forward 5 sec of time
            if (IsKeyPressed(KEY_RIGHT)){
                time += 5.toDouble()
            }

            // left arrow to skip backward 5 sec of time
            if (IsKeyPressed(KEY_LEFT)){
                time -= 5.toDouble()
            }


            for (shape in shapes){


                /* in theory this works because it runs this for every shape. this checks if another shape is colliding
                 with the current shape and if the shape has not previously collided. if so it runs
                 its doCollision method. Otherwise, if the shapes have not collided but the other shape has reset the
                 has collided boolean on the other shape to false. */

                for (oshape in otherShapes(shape)){
                    val hasCollided = CheckCollisionRecs(oshape.bounds, shape.bounds)
                    if ( hasCollided && !oshape.hasCollided){
                        oshape.hasCollided = true
                        oshape.doCollision()
                    }
                    else if (!hasCollided && oshape.hasCollided){
                        oshape.hasCollided = false
                    }
                }

                shape.draw(time.secondsSinceReset)

                // draw hit boxes
                if (debug) {
                    DrawRectangle(shape.bounds.x().toInt(), shape.bounds.y().toInt(), shape.bounds.width().toInt(),
                        shape.bounds.height().toInt(), ORANGE)

                    shape.draw(time.secondsSinceReset)
                }
            }

            if (debug) {
                DrawRectangle(0, 0, 115, 105, BLACK)
                DrawRectangle(0, 0, 110, 100, RAYWHITE)
                DrawFPS(0, 0)
                DrawText(" OS: ${System.getProperty("os.name")}", 0, 25, 10,
                    BLACK)
                DrawText(" Arch: ${System.getProperty("os.arch")}", 0, 35, 10,
                    BLACK)
                DrawText(" JRE Vendor: ${System.getProperty("java.vendor").substringBefore(" ")}",
                    0, 45, 10, BLACK)
                DrawText(" Java Version: ${System.getProperty("java.version")}", 0, 55, 10,
                    BLACK)
                DrawText(" T = ${time.secondsSinceReset}", 0, 65, 20, BLACK)
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

    // remove shapes
    operator fun minusAssign(s: Shape){
        shapes.remove(s)
    }

    fun remove(s: Shape){
        minusAssign(s)
    }

    // get other shapes from shapes list
    private fun otherShapes(s: Shape): Array<Shape> {

        // shallow copy
        val t = shapes.toMutableList()
        t.remove(s)
        return t.toTypedArray()
    }
}