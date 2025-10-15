package com.example.unit6_pathway3_project_flight_search.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    // Lấy tất cả favorite
    @Query("SELECT * FROM favorite ORDER BY id DESC")
    fun getAllFavorites(): Flow<List<Favorite>>

    // Kiểm tra một route có phải favorite không
    @Query("""
        SELECT EXISTS(
            SELECT 1 FROM favorite 
            WHERE departure_code = :departureCode 
              AND destination_code = :destinationCode
        )
    """)
    fun isRouteFavorite(departureCode: String, destinationCode: String): Flow<Boolean>

    // Thêm favorite
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavorite(Favorite: Favorite)

    // Xóa favorite
    @Query("""
        DELETE FROM favorite 
        WHERE departure_code = :departureCode 
          AND destination_code = :destinationCode
    """)
    suspend fun deleteFavorite(departureCode: String, destinationCode: String)
}