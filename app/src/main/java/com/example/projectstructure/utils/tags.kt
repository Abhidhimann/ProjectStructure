package com.example.projectstructure.utils

fun Any.classTag(): String = this::class.java.simpleName

fun Any.tempTag(): String = "tempTag"