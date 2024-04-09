package dev.refactoring.event

open class EventManager {
    val registered = mutableMapOf<Class<*>, ArrayList<(event: Any) -> Unit>>()

    inline fun <reified T : Event> register(noinline lambda: (event: T) -> Unit) {
        if(registered[T::class.java] != null) {
            registered[T::class.java]!!.add(lambda as (Any) -> Unit)
            return
        }
        registered[T::class.java] = ArrayList()
        registered[T::class.java]!!.add(lambda as (Any) -> Unit)
    }

    fun publish(event: Event) {
        registered[event::class.java]?.forEach {
            it.invoke(event)
        }
    }
}