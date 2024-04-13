import dev.refactoring.KEngine
import dev.refactoring.event.impl.EventKey
import dev.refactoring.event.impl.EventMouseClick
import dev.refactoring.event.impl.EventMousePos
import dev.refactoring.event.impl.EventResize

fun main() {
    val engine = KEngine.createEngine()

    engine.init()
    engine.show()

    engine.events.register<EventKey> {
        println("Key pressed: ${it.key} ${it.action}")
    }

    engine.events.register<EventMouseClick> {
        println("Click: ${it.action} ${it.button}")
    }

    engine.events.register<EventMousePos> {
        println("Pos: ${it.value.x} ${it.value.y}")
    }

    engine.events.register<EventResize> {
        println("Resize: ${it.size.width} ${it.size.height}")
    }

    engine.loop {
        // render here!
    }
}