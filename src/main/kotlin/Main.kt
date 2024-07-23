import com.lucaspowered.base_physics_simulation.*
import kotlin.math.*

fun main() {
    val myWorld = World("Test")
    val circle = Circle(position = Vector2(200f,200f))

    circle.equation {t: Number -> Vector2(200f, (sin(t.toFloat()) * 100 ) + 200)}
    myWorld += circle



    myWorld.run()
}

