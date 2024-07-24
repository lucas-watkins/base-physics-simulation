import com.lucaspowered.base_physics_simulation.*
import kotlin.math.*
import com.raylib.Jaylib.BLACK
import com.raylib.Jaylib.RED

fun main() {
    val myWorld = World("Test")
    myWorld.debug = true
    val circle = Circle(position = Vector2(200,200))

    // circle goes up and down because of the sine function
    circle.equation {t: Number -> Vector2(myWorld.width / 2, (sin(t as Double) * 100 ) + myWorld.height / 2)}
    myWorld += circle

    val rectangle = Rectangle(position = Vector2(100, 100))
    rectangle.equation {t: Number -> Vector2((sin(t as Double) * 100 ) + myWorld.width / 2, (myWorld.height / 2))}
    rectangle.onCollision {
        rectangle.color = when(rectangle.color) {
            RED -> BLACK
            BLACK -> RED
            else -> BLACK
        }
    }
    myWorld += rectangle

    myWorld.run()
}

