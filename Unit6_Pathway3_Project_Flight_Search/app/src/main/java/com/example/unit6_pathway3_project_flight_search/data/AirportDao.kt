package com.example.unit6_pathway3_project_flight_search.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AirportDao {

    // Tìm kiếm airport theo name hoặc iata_code (cho autocomplete)
    @Query("""
        SELECT * FROM airport 
        WHERE UPPER(name) LIKE '%' || UPPER(:query) || '%' 
           OR UPPER(iata_code) LIKE '%' || UPPER(:query) || '%'
        ORDER BY
            passengers DESC
        LIMIT 10
    """)
    fun searchAirports(query: String): Flow<List<Airport>>

    // Lấy airport theo IATA code (dùng cho favorite routes)
    @Query("SELECT * FROM airport WHERE iata_code = :iataCode LIMIT 1")
    fun getAirportByIataCode(iataCode: String): Flow<Airport?>

    // Lấy tất cả airport trừ airport đã chọn (danh sách destinations)
    @Query("""
        SELECT * FROM airport 
        WHERE iata_code != :excludeIataCode
        ORDER BY passengers DESC
    """)
    fun getDestinationAirports(excludeIataCode: String): Flow<List<Airport>>
}