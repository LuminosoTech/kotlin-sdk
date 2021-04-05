package com.luminoso.core.datafile.models

import com.luminoso.core.datafile.config.Config
import com.luminoso.core.datafile.manager.noOpKeyValueCache

data class DatafileManagerConfig(
        val autoUpdate: Boolean? = true,
        val datafile: String?,
        val sdkKey: String?,
        val updateInterval: Number = Config.DEFAULT_UPDATE_INTERVAL,
        val urlTemplate: String = Config.DEFAULT_URL_TEMPLATE,
        val cache: PersistentKeyValueCache = noOpKeyValueCache)