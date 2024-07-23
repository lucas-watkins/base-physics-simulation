package com.lucaspowered.base_physics_simulation

import com.raylib.Raylib.Color
import com.raylib.Jaylib.BLACK
import com.raylib.Raylib.DrawCircle

class Circle(override var color: Color = BLACK,
             var radius: Number = 25,
             override var position: Vector2
             ) : Shape() {

    override fun draw(t: Double){
        position = calcPos(t)
        DrawCircle(position.x.toInt(), position.y.toInt(),
                   radius.toFloat(), color)
    }

    override val bounds: Bounds
        get() {
            return Bounds(position.x, position.y, position.x.toFloat() + radius.toFloat() * 2f,
                position.y.toFloat() + radius.toFloat() * 2f)
        }
}