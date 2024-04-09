package dev.refactoring.window

import dev.refactoring.data.IntSize
import dev.refactoring.event.EventManager
import kotlin.properties.Delegates

class WindowContext(val events: EventManager) {
    val window: Window = Window(this)

    var title: String by Delegates.observable("KEngine") { _, _, newValue ->
        if (window.isInitialized) {
            window.setTitle(title)
        }
    }

    var width: Int by Delegates.observable(600) { _, _, newValue ->
        if(window.isInitialized) {
            window.setWindowSize(IntSize(newValue, height))
        }
    }

    var height: Int by Delegates.observable(400) { _, _, newValue ->
        if(window.isInitialized) {
            window.setWindowSize(IntSize(newValue, width))
        }
    }
}