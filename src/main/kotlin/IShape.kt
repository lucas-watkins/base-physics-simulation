package com.lucaspowered.base_physics_simulation

import com.raylib.Raylib.Color

interface IShape {
    // All shape classes must have these members

    // set equation with lambda function
    fun equation(f: (Number) -> Vector2)

    // function to draw shape on screen
    fun draw(t: Number)

    var calcPos: (Number) -> Vector2

    var color: Color
    var position: Vector2

}