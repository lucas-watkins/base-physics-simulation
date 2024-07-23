package com.lucaspowered.base_physics_simulation

import com.raylib.Jaylib.InitWindow
import com.raylib.Jaylib.RAYWHITE
import com.raylib.Jaylib.SetTargetFPS
import com.raylib.Raylib.ClearBackground
import com.raylib.Raylib.Color
import com.raylib.Raylib.WindowShouldClose
import com.raylib.Raylib.DrawFPS
import com.raylib.Raylib.BeginDrawing
import com.raylib.Raylib.EndDrawing
import com.raylib.Raylib.GetTime
import com.raylib.Raylib.CloseWindow

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

    fun run() {
        InitWindow(resolution[0], resolution[1], name)
        SetTargetFPS(targetFps)

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

    // use += or .add to add a shape to the world

    operator fun plusAssign(s: Shape){
        shapes += s
    }

    fun add(s: Shape){
        plusAssign(s)
    }
}