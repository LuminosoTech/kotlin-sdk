package com.luminoso.core.datafile.manager

import com.luminoso.core.datafile.BackoffController
import com.luminoso.core.datafile.EventEmitter
import com.luminoso.core.datafile.config.Config
import com.luminoso.core.datafile.models.DatafileManager
import com.luminoso.core.datafile.models.DatafileManagerConfig
import com.luminoso.core.datafile.models.DatafileUpdateListener
import com.luminoso.core.datafile.models.PersistentKeyValueCache
import com.sun.net.httpserver.Headers

val noOpKeyValueCache = object: PersistentKeyValueCache {
    override fun get(key: String): String {
        return ""
    }
    override fun set(key: String, value: String) {}
    override fun contains(key: String): Boolean {
        return false
    }
    override fun remove(key: String) {}
}


abstract class HttpPollingDatafileManager(val config: DatafileManagerConfig): DatafileManager {

    // Make an HTTP get request to the given URL with the given headers
    // Return an AbortableRequest, which has a promise for a Response.
    // If we can't get a response, the promise is rejected.
    // The request will be aborted if the manager is stopped while the request is in flight.
    abstract fun makeGetRequest(reqUrl: String, headers: Headers)

    // Return any default configuration options that should be applied
    abstract fun getConfigDefaults(): DatafileManagerConfig

    private val currentDatafile: String

    private val emitter: EventEmitter = EventEmitter()

    private val autoUpdate: Boolean = true

    private val updateInterval: Int = Config.DEFAULT_UPDATE_INTERVAL

    private val isStarted: Boolean = false

    private val lastResponseLastModified: String? = null

    private var datafileUrl: String = ""

    private val backoffController: BackoffController = BackoffController()

    private var cacheKey: String = ""

    private var cache: PersistentKeyValueCache = noOpKeyValueCache

    init {
        val configWithDefaultsApplied = this.getConfigDefaults().copy(
                autoUpdate = config.autoUpdate,
                datafile = config.datafile,
                cache = config.cache,
                sdkKey = config.sdkKey,
                updateInterval = config.updateInterval,
                urlTemplate = config.urlTemplate
        )

        this.cache = configWithDefaultsApplied.cache
        this.cacheKey = "lumi-datafile-${config.sdkKey}";
        this.datafileUrl = configWithDefaultsApplied.urlTemplate.replace("%s",configWithDefaultsApplied.sdkKey!!)

        currentDatafile = ""
    }



    override fun get(): String  {
            TODO("Not yet implemented")
    }

    override fun on(eventName: String, listener: DatafileUpdateListener): () -> Unit {
        TODO("Not yet implemented")
    }

    override fun onReady(): () -> Unit {
        TODO("Not yet implemented")
    }
}