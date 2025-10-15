package com.example.unit5_pathway2_practice_amphibians

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@OptIn(InternalSerializationApi::class)
data class Amphibian(
    val name: String,
    val type: String,
    val description: String,
    @SerialName("img_src")
    val imgSrc: String
)