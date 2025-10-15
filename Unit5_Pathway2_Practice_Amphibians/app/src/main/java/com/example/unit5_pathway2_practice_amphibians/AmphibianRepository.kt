package com.example.unit5_pathway2_practice_amphibians



interface AmphibianRepository {
    suspend fun getAmphibians(): List<Amphibian>
}

class NetworkAmphibianRepository(
    private val amphibianApiService: AmphibianApiService
) : AmphibianRepository {
    override suspend fun getAmphibians(): List<Amphibian> {
        return amphibianApiService.getAmphibians()
    }
}