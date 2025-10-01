package com.example.unit4_pathway3_project_my_city

data class Recommendation(
    val id: Int,
    val name: String,
    val imageRes: Int,
    val descriptionRes: Int,
)

data class Category(

    val title: String,
    val imageRes: Int,
    val recommendations: List<Recommendation>
)