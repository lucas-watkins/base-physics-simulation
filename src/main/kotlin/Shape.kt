package com.lucaspowered.base_physics_simulation

import com.raylib.Jaylib.BLACK
import com.raylib.Raylib.Color

// Base shape class with default options.

abstract class Shape {
    open var color: Color = BLACK

    open var position: Vector2 = Vector2(0,0)

    var calcPos = {_: Number -> Vector2(position.x, position.y)}

    fun equation(f: (Number) -> Vector2) { calcPos = f }

    // require draw function
    abstract fun draw(t: Double)

    // require function to get area
    abstract val bounds: Bounds

    // boolean for not re-colliding every frame
    var hasCollided = false

    // runs if shape has collided with another
    var doCollision = {}

    fun onCollision(f: () -> Unit){ doCollision = f}
}