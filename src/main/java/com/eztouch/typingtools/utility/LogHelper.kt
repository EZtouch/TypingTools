package com.eztouch.typingtools.utility

import org.apache.logging.log4j.Level

object LogHelper {
    private fun log(logLevel: Level, `object`: Any) {
        net.minecraftforge.fml.common.FMLLog.log(com.eztouch.typingtools.reference.Reference.MOD_NAME, logLevel, `object`.toString())
    }

    fun all(`object`: Any) {
        log(Level.ALL, `object`)
    }

    fun debug(`object`: Any) {
        log(Level.DEBUG, `object`)
    }

    fun error(`object`: Any) {
        log(Level.ERROR, `object`)
    }

    fun fatal(`object`: Any) {
        log(Level.FATAL, `object`)
    }

    fun info(`object`: Any) {
        log(Level.INFO, `object`)
    }

    fun off(`object`: Any) {
        log(Level.OFF, `object`)
    }

    fun trace(`object`: Any) {
        log(Level.TRACE, `object`)
    }

    fun warn(`object`: Any) {
        log(Level.WARN, `object`)
    }
}