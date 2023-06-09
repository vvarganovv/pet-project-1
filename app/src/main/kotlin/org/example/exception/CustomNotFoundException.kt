package org.example.exception

sealed class CustomNotFoundException(
    message: String
) : Exception(message) {

    class BookNotFoundException(id: String)
        : CustomNotFoundException("Book with id=[$id] wasn't found!")

}
