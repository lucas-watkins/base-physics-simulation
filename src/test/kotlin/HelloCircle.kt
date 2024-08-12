package com.lucaspowered.base_physics_simulation.test

import com.lucaspowered.base_physics_simulation.*
import com.lucaspowered.base_physics_simulation.shapes.Circle
import kotlin.math.sin
import kotlin.test.Test

class HelloCircle {

    @Test
    fun runTest() {
        val myWorld = World("Hello Circle")
        val circle = Circle(position = Vector2(myWorld.width / 2, myWorld.height / 2))

        circle.equation { t: Number -> Vector2(myWorld.width / 2, sin(t as Double) * 100 + myWorld.height / 2) }
        myWorld += circle

        myWorld.run()
    }
}
