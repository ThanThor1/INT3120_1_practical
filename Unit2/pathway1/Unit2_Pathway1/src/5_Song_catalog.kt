fun main() {
    val song1 = Song("Shape of You", "Ed Sheeran", 2017, 500)
    song1.printDescription()
    println("Is this song popular? " + song1.isPopular)
}

class Song(val title: String, val artist: String, val yearPublished: Int, val playCount: Int) {
    val isPopular: Boolean
        get() = playCount >= 1000
    fun printDescription() {
        println(title + ", performed by " + artist + ", was released in " + yearPublished + ".")
    }
}
