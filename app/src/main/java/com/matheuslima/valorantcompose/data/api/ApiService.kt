package com.matheuslima.valorantcompose.data.api

import com.matheuslima.utilities.UtilConstants.US
import com.matheuslima.valorantcompose.data.response.entities.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("agents")
    suspend fun getAgents(
        @Query("language") language: String? = US
    ): Response<Agents>

    @GET("agents/{agentUuid}")
    suspend fun getAgentByUuid(
        @retrofit2.http.Path("agentUuid") agentUuid: String,
        @Query("language") language: String? = US
    ): Response<SingleAgentResponse>

    @GET("weapons")
    suspend fun getWeapons(
        @Query("language") language: String? = US
    ): Response<WeaponResponse>

    @GET("weapons/{weaponUuid}")
    suspend fun getWeaponByUuid(
        @retrofit2.http.Path("weaponUuid") weaponUuid: String,
        @Query("language") language: String? = US
    ): Response<SingleWeaponResponse>

    @GET("maps")
    suspend fun getMaps(
        @Query("language") language: String? = US
    ): Response<MapResponse>

    @GET("maps/{mapUuid}")
    suspend fun getMapByUuid(
        @retrofit2.http.Path("mapUuid") mapUuid: String,
        @Query("language") language: String? = US
    ): Response<SingleMapResponse>

    @GET("playertitles")
    suspend fun getTitles(
        @Query("language") language: String? = US
    ): Response<TitleResponse>

    @GET("playertitles/{titleUuid}")
    suspend fun getTitleByUuid(
        @retrofit2.http.Path("titleUuid") titleUuid: String,
        @Query("language") language: String? = US
    ): Response<SingleTitleResponse>

    @GET("playercards")
    suspend fun getPlayerCards(
        @Query("language") language: String? = US
    ): Response<PlayerCardResponse>

    @GET("playercards/{cardUuid}")
    suspend fun getPlayerCardByUuid(
        @retrofit2.http.Path("cardUuid") cardUuid: String,
        @Query("language") language: String? = US
    ): Response<SinglePlayerCardResponse>

    @GET("currencies")
    suspend fun getCurrencies(
        @Query("language") language: String? = US
    ): Response<CurrencyResponse>

    @GET("currencies/{currencyUuid}")
    suspend fun getCurrencyByUuid(
        @retrofit2.http.Path("currencyUuid") currencyUuid: String,
        @Query("language") language: String? = US
    ): Response<SingleCurrencyResponse>

    @GET("gamemodes")
    suspend fun getGameModes(
        @Query("language") language: String? = US
    ): Response<GameModeResponse>

    @GET("gamemodes/{modeUuid}")
    suspend fun getGameModeByUuid(
        @retrofit2.http.Path("modeUuid") modeUuid: String,
        @Query("language") language: String? = US
    ): Response<SingleGameModeResponse>

    @GET("seasons")
    suspend fun getSeasons(
        @Query("language") language: String? = US
    ): Response<SeasonResponse>

    @GET("seasons/{seasonUuid}")
    suspend fun getSeasonByUuid(
        @retrofit2.http.Path("seasonUuid") seasonUuid: String,
        @Query("language") language: String? = US
    ): Response<SingleSeasonResponse>
}