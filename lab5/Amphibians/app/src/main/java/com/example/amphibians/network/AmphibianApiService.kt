package com.example.amphibians.network

import com.example.amphibians.model.Amphibian
import retrofit2.http.GET


// Retrofit API service
interface AmphibianApiService {
    @GET("amphibians")
    suspend fun getAmphibians(): List<Amphibian>
}

// Retrofit instance
object RetrofitInstance {
    val api: AmphibianApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://android-kotlin-fun-mars-server.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AmphibianApiService::class.java)
    }
}