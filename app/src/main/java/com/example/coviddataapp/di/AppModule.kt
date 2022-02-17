package com.example.coviddataapp.di

import com.example.coviddataapp.common.Constants.BASE_URL
import com.example.coviddataapp.damain.repository.CovidRepository
import com.example.coviddataapp.data.remote.CovidApi
import com.example.coviddataapp.data.repository.CovidRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCovidApi(): CovidApi{
        val client = OkHttpClient.Builder().addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response = chain.run {
                proceed(
                    request()
                        .newBuilder()
                        .addHeader("x-rapidapi-host", "covid-193.p.rapidapi.com")
                        .addHeader("x-rapidapi-key", "5bdf33f0e3msh634c735127984cfp15ef84jsn40a575454c90")
                        .build()
                )
            }
        }).build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(CovidApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api:CovidApi): CovidRepository {
        return CovidRepositoryImpl(api)
    }

}