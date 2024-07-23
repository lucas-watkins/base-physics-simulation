package com.lucaspowered.base_physics_simulation

import com.raylib.Jaylib.*
import com.raylib.Raylib.Color

typealias Vector2 = com.raylib.Jaylib.Vector2

class World(private val name: String,
            var color: Color = RAYWHITE,
            private val resolution: Array<Int> = arrayOf(400, 400)
            ) {

    var shapes = mutableListOf<IShape>()

    fun run() {
        InitWindow(resolution[0], resolution[1], name)
        SetTargetFPS(60)

        while (!WindowShouldClose()) {
            // update loop
            ClearBackground(color)
            BeginDrawing()
            DrawFPS(0,0)

            val time = GetTime()
            for (shape in shapes){
                shape.draw(time)
            }

            EndDrawing()
        }

        CloseWindow()
    }

    operator fun plusAssign(s: IShape){
        shapes += s
    }
}