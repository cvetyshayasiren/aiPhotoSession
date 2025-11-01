package com.cvetyshayasiren.aiphotosession

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform