package dev.refactoring.event.impl

import dev.refactoring.data.DoublePoint
import dev.refactoring.event.Event

/**
 * Called when the user moves the mouse and the window is active.
 */
class EventMousePos(
    val value: DoublePoint
) : Event