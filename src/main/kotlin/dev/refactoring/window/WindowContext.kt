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

    var _width = 600
    var _height = 400

    var width: Int
        get() = _width
        set(value) {
            if (window.isInitialized) {
                _width = value
                window.setWindowSize(IntSize(value, height))
            }
        }

    var height: Int
        get() = _height
        set(value) {
            if (window.isInitialized) {
                _height = value
                window.setWindowSize(IntSize(width, value))
            }
        }
}