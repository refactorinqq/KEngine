package dev.refactoring

import dev.refactoring.event.EventManager
import dev.refactoring.window.WindowContext

/**
 * The engine class.
 */
class KEngine private constructor(val events: EventManager, private val ctx: WindowContext) : EventManager() {
    /**
     * Initialize a new context
     */
    fun init() {
        ctx.window.init()
    }

    /**
     * Show the active window
     */
    fun show() {
        if(!ctx.window.isInitialized) throw IllegalStateException("Window isn't initialized")
        ctx.window.show()
    }

    /**
     * Create a loop.
     */
    fun loop(clearColor: Boolean = true, block: () -> Unit) {
        ctx.window.loop(clearColor) {
            block()
        }
    }

    companion object {
        /**
         * Create a new engine with the default window context settings.
         */
        fun createEngine(): KEngine {
            val eventManager = EventManager()
            return KEngine(eventManager, WindowContext(eventManager))
        }

        /**
         * Create a new engine with custom options.
         */
        fun createEngine(events: EventManager, context: WindowContext): KEngine {
            return KEngine(events, context)
        }
    }
}