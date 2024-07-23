package com.lucaspowered.base_physics_simulation

import com.raylib.Jaylib.BLACK

// Base shape class with default options. Implements IShape interface

open class Shape : IShape {
    override var color = BLACK

    override var position = Vector2(0f, 0f);

    override var calcPos = {_:Number -> Vector2(position.x(), position.y())}

    override fun equation(f: (Number) -> Vector2) { calcPos = f }
    override fun draw(t: Number) {}
}