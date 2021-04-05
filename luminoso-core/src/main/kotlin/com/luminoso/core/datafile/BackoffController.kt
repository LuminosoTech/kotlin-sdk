package com.luminoso.core.datafile

import com.luminoso.core.datafile.config.Config
import kotlin.math.min
import kotlin.math.roundToInt

class BackoffController {

    private var errorCount: Int = 0

    fun getDelay(): Int {
        if(errorCount == 0) {
            return 0
        }

        val baseWaitSeconds = Config.BACKOFF_BASE_WAIT_SECONDS_BY_ERROR_COUNT[min(Config.BACKOFF_BASE_WAIT_SECONDS_BY_ERROR_COUNT.size - 1, errorCount)]
        return baseWaitSeconds * 1000 + randomMilliseconds()
    }

    fun countError() {
        if (errorCount < Config.BACKOFF_BASE_WAIT_SECONDS_BY_ERROR_COUNT.size - 1) {
            errorCount++;
        }
    }

    fun reset() {
        errorCount = 0;
    }

    private fun randomMilliseconds(): Int {
        return (Math.random() * 1000).roundToInt()
    }
}