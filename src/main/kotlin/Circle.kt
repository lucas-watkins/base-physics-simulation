package com.lucaspowered.base_physics_simulation

import com.raylib.Raylib.Color
import com.raylib.Jaylib.BLACK
import com.raylib.Raylib.DrawCircle

class Circle(override var color: Color = BLACK,
             var radius: Float = 25f,
             override var position: Vector2
             ) : Shape() {

    override fun draw(t: Number){
        position = calcPos(t)
        DrawCircle(position.x().toInt(), position.y().toInt(),
                   radius, color)
    }
}