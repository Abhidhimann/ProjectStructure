package com.example.projectstructure.utils


//https://api.weatherapi.com/v1/current.json?key=59b6dbb4&q=London&aqi=no
enum class Api(private val url: String) {
    BASE_URL("https://api.weatherapi.com/v1/"),
    POSTER_BASE_URL("https://image.tmdb.org/t/p/w342"),
    TIME_OUT("6");

    fun getValue(): String{
        return url
    }
}