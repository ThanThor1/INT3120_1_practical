package com.example.unit2_pathway3_project_create_an_art_space_app

class ArtGallery {
    val artList = listOf(
        ArtPiece(
            imageRes = R.drawable.starry_night,
            title = "Starry Night",
            artist = "Vincent van Gogh",
            year = "1889"
        ),
        ArtPiece(
            imageRes = R.drawable.girl_with_a_pearl_earring,
            title = "Girl with a Pearl Earring",
            artist = "Johannes Vermeer",
            year = "1665"
        ),
        ArtPiece(
            imageRes = R.drawable.the_scream,
            title = "The Scream",
            artist = "Edvard Munch",
            year = "1893"
        ),
    )

    fun getArtPiece(index: Int): ArtPiece = artList[index]
    fun getTotalCount(): Int = artList.size
}