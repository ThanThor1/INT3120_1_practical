package com.example.unit6_pathway3_project_flight_search.data


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "flight_search_preferences"
)

class UserPreferencesRepository(private val context: Context) {

    private companion object {
        val SEARCH_QUERY = stringPreferencesKey("search_query")
        val SELECTED_AIRPORT_CODE = stringPreferencesKey("selected_airport_code")
    }

    /**
     * Lưu search query
     */
    suspend fun saveSearchQuery(query: String) {
        context.dataStore.edit { preferences ->
            preferences[SEARCH_QUERY] = query
        }
    }

    /**
     * Lưu airport đã chọn (chỉ lưu IATA code)
     */
    suspend fun saveSelectedAirport(iataCode: String?) {
        context.dataStore.edit { preferences ->
            if (iataCode != null) {
                preferences[SELECTED_AIRPORT_CODE] = iataCode
            } else {
                preferences.remove(SELECTED_AIRPORT_CODE)
            }
        }
    }

    /**
     * Đọc search query đã lưu
     */
    val searchQuery: Flow<String> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            preferences[SEARCH_QUERY] ?: ""
        }

    /**
     * Đọc selected airport code đã lưu
     */
    val selectedAirportCode: Flow<String?> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            preferences[SELECTED_AIRPORT_CODE]
        }
}