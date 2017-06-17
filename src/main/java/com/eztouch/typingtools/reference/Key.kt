package com.eztouch.typingtools.reference

enum class Key {

    UNKNOWN, FANCYCHAT;


    companion object {

        val KEYS = Key.values()

        fun getKey(ordinal: Byte): Key {
            return KEYS[ordinal % KEYS.size]
        }
    }
}