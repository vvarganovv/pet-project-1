package org.example.service

import org.example.model.Book
import org.example.model.dto.BookPostDto
import org.example.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {

    fun findAll(pageable: Pageable): Page<Book> =
        bookRepository.findAll(pageable)

    fun insertOne(body: BookPostDto): Book {
        val book = Book(body.name, body.author)

        return bookRepository.save(book)
    }

}
