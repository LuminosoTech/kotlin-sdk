package com.luminoso.core.datafile

typealias Disposer = () -> Unit

typealias Listener = (arg: Any?) -> Unit

typealias Listeners = MutableMap<String, Listener>

class EventEmitter {

    private val listeners = mutableMapOf<String, Listeners>()
    private var listenerId = 1

    fun on(eventName: String, listener: Listener): Disposer {
        if(this.listeners.containsKey(eventName).not()){
            this.listeners[eventName] = mutableMapOf()
        }

        val currentListenerId = this.listenerId.toString()
        this.listenerId++
        this.listeners[eventName]!![currentListenerId] = listener

        return  {
            if(eventName in this.listeners) {
                this.listeners.remove(eventName)
            }
        }
    }

    fun emit(eventName: String, arg: Any?) {
        val listeners = this.listeners[eventName]
        if (listeners !== null) {
            for (listenerId in listeners.keys) {
                listeners[listenerId]?.let { listener ->
                    listener(arg)
                }
            }
        }
    }

    fun removeAllListeners() {
        this.listeners.clear()
    }
}