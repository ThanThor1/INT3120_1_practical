
package com.example.unit5_pathway2_project_bookshelf

import android.annotation.SuppressLint
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class SearchIdResponse(
    @SerialName("items")
    val items: List<BookItem>? = null
)

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class BookItem(
    @SerialName("id")
    val id: String
)

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class BookDetailResponse(
    @SerialName("id")
    val id: String,
    @SerialName("volumeInfo")
    val volumeInfo: VolumeInfo
)

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class VolumeInfo(
    @SerialName("imageLinks")
    val imageLinks: ImageLinks? = null
)

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class ImageLinks(
    @SerialName("thumbnail")
    val thumbnail: String? = null
)

data class Book(
    val id: String,
    val imgUrl: String
)