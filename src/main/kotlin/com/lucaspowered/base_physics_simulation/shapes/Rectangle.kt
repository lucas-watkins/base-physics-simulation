package com.lucaspowered.base_physics_simulation.shapes

import com.lucaspowered.base_physics_simulation.Bounds
import com.lucaspowered.base_physics_simulation.Vector2
import com.raylib.Jaylib.BLACK
import com.raylib.Raylib.Color
import com.raylib.Raylib.DrawRectangle

class Rectangle(override var color: Color = BLACK,
                var width: Int = 50,
                var height: Int = 50,
                override var position: Vector2 = Vector2(0,0)
) : Shape()
{
    override fun draw(t: Double){
        position = calcPos(t)
        DrawRectangle(position.x.toInt(), position.y.toInt(), width, height, color)
    }

    override val bounds: Bounds
        get() {
            return Bounds(position.x.toFloat(), position.y.toFloat(), width.toFloat(), height.toFloat())
        }
}