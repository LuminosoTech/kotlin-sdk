package com.luminoso.core.datafile.models

interface PersistentKeyValueCache {
    /**
     * Returns value stored against a key or null if not found.
     * @param key
     * @returns
     * Resolves promise with
     * 1. string if value found was stored as a string.
     * 2. null if the key does not exist in the cache.
     * Rejects the promise in case of an error
     */
    fun get(key: String): String

    /**
     * Stores string in the persistent cache against a key
     * @param key
     * @param val
     * @returns
     * Resolves promise without a value if successful
     * Rejects the promise in case of an error
     */
    fun set(key: String, value: String)

    /**
     * Checks if a key exists in the cache
     * @param key
     * Resolves promise with
     * 1. true if the key exists
     * 2. false if the key does not exist
     * Rejects the promise in case of an error
     */
    fun contains(key: String): Boolean;

    /**
     * Removes the key value pair from cache.
     * @param key
     * Resolves promise without a value if successful
     * Rejects the promise in case of an error
     */
    fun remove(key: String);
}