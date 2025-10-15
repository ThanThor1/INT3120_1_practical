package com.example.unit5_pathway2_project_bookshelf

interface BookRepository {
    suspend fun searchAndGetBooks(query: String): List<Book>
}

class NetworkBookRepository(
    private val bookApiService: BookApiService
) : BookRepository {

    override suspend fun searchAndGetBooks(query: String): List<Book> {
        // tìm kiếm id
        val searchIdResponse = bookApiService.searchIdBooks(query)
        val bookIds = searchIdResponse.items?.map { it.id } ?: emptyList()

        // lấy chi tiết sách
        val books = bookIds.mapNotNull { id ->
            try {
                val detail = bookApiService.getBookDetail(id)
                val thumbnailUrl = detail.volumeInfo.imageLinks?.thumbnail

                if (thumbnailUrl != null) {
                    Book(
                        id = detail.id,
                        imgUrl = thumbnailUrl
                    )
                } else {
                    null
                }
            } catch (e: Exception) {
                null
            }
        }

        return books
    }
}