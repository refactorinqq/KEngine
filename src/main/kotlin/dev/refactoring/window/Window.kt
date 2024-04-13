package dev.refactoring.window

import dev.refactoring.data.Action
import dev.refactoring.data.DoublePoint
import dev.refactoring.data.IntSize
import dev.refactoring.event.impl.*
import dev.refactoring.window.exception.WindowInitializationException
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWErrorCallback
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11.*
import org.lwjgl.system.MemoryUtil.NULL
import kotlin.properties.Delegates


class Window(private val context: WindowContext) {
    private var shown: Boolean = false
    var isInitialized = false
    private var handle by Delegates.notNull<Long>()

    fun init() {
        GLFWErrorCallback.createPrint(System.err).set()

        if (!glfwInit())
            throw WindowInitializationException("Unable to initialize GLFW")

        glfwDefaultWindowHints()
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE)

        handle = glfwCreateWindow(context.width, context.height, context.title, NULL, NULL)

        if (handle == NULL)
            throw WindowInitializationException("Failed to create the GLFW window")

        glfwSetKeyCallback(
            handle
        ) { _: Long, key: Int, scancode: Int, action: Int, mods: Int ->
            context.events.publish(EventKey(
                key,
                scancode,
                Action.of(action),
                mods
            ))
        }

        glfwSetCursorPosCallback(handle) { _, xpos, ypos ->
            context.events.publish(EventMousePos(
                DoublePoint(xpos, ypos)
            ))
        }

        glfwSetMouseButtonCallback(handle) { _, button, action, _ ->
            context.events.publish(EventMouseClick(
                MouseButton.of(button),
                Action.of(action)
            ))
        }

        glfwSetWindowSizeCallback(
            handle,
        ) { _, width, height ->
            context.events.publish(EventResize(IntSize(width, height)))

            context._width = width
            context._height = height
        }

        glfwMakeContextCurrent(handle);

        isInitialized = true
    }

    fun show() {
        shown = true
        glfwShowWindow(handle)
    }

    fun setTitle(title: String) {
        glfwSetWindowTitle(handle, title)
    }

    fun setWindowSize(size: IntSize) {
        glfwSetWindowSize(handle, size.width, size.height)
    }

    fun loop(clearColor: Boolean, block: () -> Unit) {
        GL.createCapabilities()

        if(clearColor)
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f)

        while (!glfwWindowShouldClose(handle)) {
            glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT) // clear the framebuffer

            block()

            glfwSwapBuffers(handle)
            glfwPollEvents()
        }
    }
}