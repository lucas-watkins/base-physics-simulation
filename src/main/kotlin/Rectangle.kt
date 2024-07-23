package com.lucaspowered.base_physics_simulation

import com.raylib.Jaylib.BLACK
import com.raylib.Raylib.Color
import com.raylib.Raylib.DrawRectangle

class Rectangle(override var color: Color = BLACK,
                var width: Int = 50,
                var height: Int = 50,
                override var position: Vector2 = Vector2(0,0)
) : Shape()
{
    override fun draw(t: Number){
        DrawRectangle(position.x as Int, position.y as Int, width, height, color)
    }
}