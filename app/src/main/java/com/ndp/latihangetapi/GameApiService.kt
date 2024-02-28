package com.ndp.latihangetapi

import retrofit2.Call
import retrofit2.http.GET

interface GameApiService {
    @GET("games?key=bf71302e09a94b1790fc08b54e04af71")
    fun getGames(): Call<GameResponse>
}