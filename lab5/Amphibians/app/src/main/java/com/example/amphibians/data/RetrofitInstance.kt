package com.example.amphibians.data

import com.example.amphibians.network.AmphibianApiService
import retrofit2.Retrofit
import com.example.amphibians.model.Amphibian

class AmphibianRepositoryImpl(private val apiService: AmphibianApiService) : AmphibianRepository {
    override suspend fun getAmphibians(): List<Amphibian> = apiService.getAmphibians()
}

object RetrofitInstance {
    val api: AmphibianApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://android-kotlin-fun-mars-server.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AmphibianApiService::class.java)
    }
}
