import com.lucaspowered.base_physics_simulation.*
import kotlin.math.*


fun main() {
    val myWorld = World("Test")
    val circle = Circle(position = Vector2(200,200))

    // circle goes up and down because of the sine function
    circle.equation {t: Number -> Vector2(200, (sin(t as Double) * 100 ) + 200)}
    myWorld += circle

    myWorld.run()
}

