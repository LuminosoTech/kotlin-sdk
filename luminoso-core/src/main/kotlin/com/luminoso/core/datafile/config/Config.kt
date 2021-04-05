package com.luminoso.core.datafile.config

class Config {
    companion object {
        const val DEFAULT_UPDATE_INTERVAL = 5 * 60 * 1000 // 5 minutes
        const val MIN_UPDATE_INTERVAL = 1000
        const val DEFAULT_URL_TEMPLATE = "http://localhost:5000/datafiles/%s.json"
        const val DEFAULT_AUTHENTICATED_URL_TEMPLATE = "https://config.luminoso.tech/datafiles/auth/%s.json"
        val BACKOFF_BASE_WAIT_SECONDS_BY_ERROR_COUNT = listOf(0, 8, 16, 32, 64, 128, 256, 512)
        const val REQUEST_TIMEOUT_MS = 60 * 1000 // 1 minute
    }
}