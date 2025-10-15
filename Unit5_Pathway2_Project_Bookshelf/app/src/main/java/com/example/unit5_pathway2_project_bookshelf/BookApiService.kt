package com.example.unit5_pathway2_project_bookshelf

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface BookApiService {
    // tìm id
    @GET("volumes")
    suspend fun searchIdBooks(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int = 20  // lấy tối đa 20 sách
    ): SearchIdResponse

    // lấy thông tin chi tiết
    @GET("volumes/{volumeId}")
    suspend fun getBookDetail(@Path("volumeId") volumeId: String): BookDetailResponse
}