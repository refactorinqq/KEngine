import dev.refactoring.KEngine
import dev.refactoring.event.impl.EventKey

fun main() {
    val engine = KEngine.createEngine()

    engine.init()
    engine.show()

    engine.events.register<EventKey> {
        println("Key pressed: ${it.key}")
    }

    engine.loop {
        // render here!
    }
}