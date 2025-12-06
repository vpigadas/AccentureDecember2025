package com.example.myapplication.feature

import java.util.Date

enum class Days(val code: String) {
    M("M"),
    Tu("T2"),
    W("W"),
    Th("T4"),
    F("F"),
    Sat("Sat"),
    Sun("Sun"),
    NEW("NEW");

    fun getDay(): String = code
}

sealed class Days2 {

    private val _name = "Days2"

    object M : Days2()
    object Tu : Days2()
    object W : Days2()
    object Th : Days2()
    object F : Days2()
    object Sat : Days2()
    object Sun : Days2()

    data class New(val name: String, val delay: Double) : Days2()
}

sealed class HostException {

    fun getTimestamp(): String {
        return Date(System.currentTimeMillis()).toString()
    }

    object TIME_OUT : HostException()
    object NO_INTERNET : HostException()

    data class Exception(val code: Int, val cause: String, val hostMessage: String) :
        HostException()
}