package com.matheuslima.valorantcompose.di

import com.google.gson.Gson
import com.matheuslima.utilities.UtilConstants.APP_BASE_URL
import com.matheuslima.valorantcompose.data.api.ApiService
import com.matheuslima.valorantcompose.data.datasource.interfaces.AgentsDataSource
import com.matheuslima.valorantcompose.data.datasource.remote.RemoteAgentsDataSourceImpl
import com.matheuslima.valorantcompose.data.repository.AgentsRepository
import com.matheuslima.valorantcompose.data.repository.AgentsRepositoryImpl
import com.matheuslima.valorantcompose.ui.helper.DefaultDispatchers
import com.matheuslima.valorantcompose.ui.helper.DispatcherProvider
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
    fun providesDefaultDispatchers(): DispatcherProvider {
        return DefaultDispatchers()
    }
    @Singleton
    @Provides
    fun providesAgentsRepository(agentsDataSource: AgentsDataSource, dispatchers: DispatcherProvider): AgentsRepository {
        return AgentsRepositoryImpl(agentsDataSource, dispatchers)
    }
}