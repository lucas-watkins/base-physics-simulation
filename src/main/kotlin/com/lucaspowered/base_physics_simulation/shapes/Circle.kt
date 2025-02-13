package com.lucaspowered.base_physics_simulation.shapes

import com.lucaspowered.base_physics_simulation.Bounds
import com.lucaspowered.base_physics_simulation.Vector2
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
            return Bounds(position.x.toFloat() - radius.toFloat(),
                position.y.toFloat() - radius.toFloat(), radius.toFloat() * 2f, radius.toFloat() * 2f)
        }
}