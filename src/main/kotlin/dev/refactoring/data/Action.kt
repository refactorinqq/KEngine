package dev.refactoring.data

import org.lwjgl.glfw.GLFW

enum class Action(val value: Int) {
    PRESS(GLFW.GLFW_PRESS),
    RELEASE(GLFW.GLFW_RELEASE),
    // The following is only for keyboards.
    REPEAT(GLFW.GLFW_REPEAT);

    companion object {
        fun of(value: Int): Action {
            return Action.entries.find { it.value == value }!!
        }
    }
}
