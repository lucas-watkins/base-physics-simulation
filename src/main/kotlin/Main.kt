import com.lucaspowered.base_physics_simulation.*
import kotlin.math.sin

fun main() {
    val myWorld = World("Hello Circle")
    val circle = Circle(position = Vector2(myWorld.width / 2, myWorld.height / 2))

    circle.equation {t: Number -> Vector2(myWorld.width / 2, sin(t as Double) * 100 + myWorld.height / 2)}
    myWorld += circle

    myWorld.run()
}
