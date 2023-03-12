package com.example.whatsappclone.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {

    companion object{
        const val BASE_URL = "https://kitsu.io/api/edge/"
    }

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit? {
        val headerInterceptor = HeaderInterceptor()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(headerInterceptor)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit
    }
}

class HeaderInterceptor: Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val origin = chain.request()
        val request = origin.newBuilder()
            .addHeader("Authorization", "")
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept-Language", "")
            .build()

        return chain.proceed(request)
    }
}