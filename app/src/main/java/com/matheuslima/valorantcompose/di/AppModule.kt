package com.matheuslima.valorantcompose.di

import com.google.gson.Gson
import com.matheuslima.utilities.UtilConstants.APP_BASE_URL
import com.matheuslima.valorantcompose.data.api.ApiService
import com.matheuslima.valorantcompose.data.datasource.interfaces.AgentsDataSource
import com.matheuslima.valorantcompose.data.datasource.remote.RemoteAgentsDataSourceImpl
import com.matheuslima.valorantcompose.data.repository.*
import com.matheuslima.valorantcompose.domain.repository.*
import com.matheuslima.valorantcompose.domain.usecase.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
        val client = OkHttpClient().newBuilder().apply {
            addInterceptor(interceptor = interceptor)
            readTimeout(60, TimeUnit.SECONDS)
        }.build()
        return Retrofit.Builder()
            .baseUrl(APP_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesRemoteAgentsDataSource(apiService: ApiService): AgentsDataSource {
        return RemoteAgentsDataSourceImpl(apiService)
    }

    @Singleton
    @Provides
    fun providesAgentsRepository(agentsDataSource: AgentsDataSource): AgentsRepository {
        return AgentsRepositoryImpl(agentsDataSource)
    }

    @Singleton
    @Provides
    fun providesGetAgentsUseCase(agentsRepository: AgentsRepository): GetAgentsUseCase {
        return GetAgentsUseCase(agentsRepository)
    }

    @Singleton
    @Provides
    fun providesWeaponsRepository(apiService: ApiService): WeaponsRepository {
        return WeaponsRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun providesMapsRepository(apiService: ApiService): MapsRepository {
        return MapsRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun providesGetWeaponsUseCase(weaponsRepository: WeaponsRepository): GetWeaponsUseCase {
        return GetWeaponsUseCase(weaponsRepository)
    }

    @Singleton
    @Provides
    fun providesGetMapsUseCase(mapsRepository: MapsRepository): GetMapsUseCase {
        return GetMapsUseCase(mapsRepository)
    }

    @Singleton
    @Provides
    fun providesContentRepository(apiService: ApiService): ContentRepository {
        return ContentRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun providesGetTitlesUseCase(contentRepository: ContentRepository): GetTitlesUseCase {
        return GetTitlesUseCase(contentRepository)
    }

    @Singleton
    @Provides
    fun providesGetPlayerCardsUseCase(contentRepository: ContentRepository): GetPlayerCardsUseCase {
        return GetPlayerCardsUseCase(contentRepository)
    }

    @Singleton
    @Provides
    fun providesGetCurrenciesUseCase(contentRepository: ContentRepository): GetCurrenciesUseCase {
        return GetCurrenciesUseCase(contentRepository)
    }

    @Singleton
    @Provides
    fun providesGetGameModesUseCase(contentRepository: ContentRepository): GetGameModesUseCase {
        return GetGameModesUseCase(contentRepository)
    }

    @Singleton
    @Provides
    fun providesGetSeasonsUseCase(contentRepository: ContentRepository): GetSeasonsUseCase {
        return GetSeasonsUseCase(contentRepository)
    }
}