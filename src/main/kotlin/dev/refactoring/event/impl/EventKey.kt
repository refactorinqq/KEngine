package dev.refactoring.event.impl

import dev.refactoring.data.Action
import dev.refactoring.event.Event

/**
 * Called when a key is pressed.
 */
class EventKey(
    val key: Int,
    val scancode: Int,
    val action: Action,
    val mods: Int
) : Event