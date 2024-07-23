import com.lucaspowered.base_physics_simulation.*
import kotlin.math.*


fun main() {
    val myWorld = World("Test")
    val circle = Circle(position = Vector2(200,200))

    // circle goes up and down because of the sine function
    circle.equation {t: Number -> Vector2(myWorld.width / 2, (sin(t as Double) * 100 ) + myWorld.height / 2)}
    myWorld += circle

    val rectangle = Rectangle(position = Vector2(100, 100))
    myWorld += rectangle

    myWorld.run()
}

