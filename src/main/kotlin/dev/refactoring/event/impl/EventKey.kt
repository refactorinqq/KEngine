package dev.refactoring.event.impl

import dev.refactoring.event.Event

class EventKey(
    val key: Int,
    val scancode: Int,
    val action: Int,
    val mods: Int
) : Event()