package dev.refactoring.event.impl

import dev.refactoring.data.IntSize
import dev.refactoring.event.Event

/**
 * Called when the window is resized.
 */
class EventResize(
    val size: IntSize
) : Event