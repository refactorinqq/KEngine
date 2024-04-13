package dev.refactoring.event.impl

import dev.refactoring.data.Action
import dev.refactoring.event.Event
import org.lwjgl.glfw.GLFW

/**
 * Called when a mouse button is pressed.
 */
class EventMouseClick(
    val button: MouseButton,
    val action: Action
) : Event

enum class MouseButton(val value: Int) {
    LEFT(GLFW.GLFW_MOUSE_BUTTON_LEFT),
    MIDDLE(GLFW.GLFW_MOUSE_BUTTON_MIDDLE),
    RIGHT(GLFW.GLFW_MOUSE_BUTTON_RIGHT),
    FOUR(GLFW.GLFW_MOUSE_BUTTON_4),
    FIVE(GLFW.GLFW_MOUSE_BUTTON_5),
    SIX(GLFW.GLFW_MOUSE_BUTTON_6),
    SEVEN(GLFW.GLFW_MOUSE_BUTTON_7),
    EIGHT(GLFW.GLFW_MOUSE_BUTTON_8);

    companion object {
        fun of(value: Int): MouseButton {
            return MouseButton.entries.find { it.value == value }!!
        }
    }
}