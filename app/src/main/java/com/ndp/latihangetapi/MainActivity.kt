package com.ndp.latihangetapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService = RetrofitClient.create(this)

        apiService.getGames().enqueue(object : Callback<GameResponse> {
            override fun onResponse(call: Call<GameResponse>, response: Response<GameResponse>) {
                if (response.isSuccessful) {
                    val gameResponse = response.body()
                    gameResponse?.results?.forEach { game ->
                        Log.d("Game", "${game.name} - ${game.rating}")
                    }
                } else {
                    Log.e("API Error", "Failed to fetch games: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<GameResponse>, t: Throwable) {
                Log.e("Network Error", "Failed to fetch games", t)
            }
        })
    }
}