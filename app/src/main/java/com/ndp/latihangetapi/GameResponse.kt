package com.ndp.latihangetapi

data class GameResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Game>
)
