package dev.refactoring.event.impl

import dev.refactoring.data.IntSize
import dev.refactoring.event.Event

class EventResize(
    val size: IntSize
) : Event()