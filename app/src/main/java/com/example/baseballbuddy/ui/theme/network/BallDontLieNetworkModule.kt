package com.example.baseballbuddy.ui.theme.network

import com.example.baseballbuddy.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * BallDontLieNetworkModule sets up and provides a reusable and configured instance of TeamApiService
 * so the rest of the app can easily make HTTP requests without duplicating setup code.
 */
object BallDontLieNetworkModule {

    private const val BASE_URL = "https://api.balldontlie.io/"
    private const val AUTHORIZATION_KEY = "Authorization"

    /**
     * An OkHttp interceptor that intercepts every outgoing HTTP request.
     */
    private val authInterceptor = Interceptor { chain ->
        // Get the original request from the chain
        val request = chain
            .request() // Retrieves the original Request object from the chain
            .newBuilder() // Creates a new Request.Builder from the original request (to allow modifications)
            .addHeader(AUTHORIZATION_KEY, BuildConfig.BALL_DONT_LIE_API_KEY) // Adds the Authorization header with the API key
            .build() // Builds the modified Request object

        // Proceed with the modified request down the chain (sends it to the server)
        chain.proceed(request)
    }

    /**
     * A customized OkHttpClient that uses the [BallDontLieNetworkModule.authInterceptor]
     * Responsible for executing network requests under the hood for Retrofit.
     */
    private val okHttpClient = OkHttpClient.Builder() // Starts building an OkHttpClient
        .addInterceptor(authInterceptor) // Adds the interceptor that injects the Authorization header into each request
        .build() // Builds and returns the configured OkHttpClient instance

    private val retrofit: Retrofit = Retrofit.Builder() // Starts building a Retrofit instance
        .baseUrl(BASE_URL) // Sets the base URL for all API endpoints
        .client(okHttpClient) // Attaches the custom OkHttpClient (with interceptor) to handle HTTP requests
        .addConverterFactory(GsonConverterFactory.create()) // Adds a converter to automatically serialize/deserialize JSON using Gson
        .build() // Builds and returns the configured Retrofit instance

    /**
     * A Retrofit implementation of the TeamApiService interface.
     */
    val teamApiService: TeamApiService = retrofit.create(TeamApiService::class.java)
}