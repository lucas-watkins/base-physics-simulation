package com.lucaspowered.base_physics_simulation

class Bounds(var x: Number, var y: Number, var x_ending: Number, var y_ending: Number) {

    fun intersects(b: Bounds): Boolean {
        return (x.toFloat() <= b.x.toFloat() && b.x.toFloat() <= x_ending.toFloat()) &&
                (y.toFloat() <= b.y.toFloat() && b.y.toFloat() <= y_ending.toFloat())
    }
}