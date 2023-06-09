package org.example.service

import org.example.exception.CustomNotFoundException.BookNotFoundException
import org.example.model.Book
import org.example.model.dto.BookPostDto
import org.example.model.dto.BookPutDto
import org.example.repository.BookRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.getOrElse

@Service
class BookService(
    private val bookRepository: BookRepository
) {

    fun findAll(pageable: Pageable): List<Book> =
        bookRepository.findAll(pageable).content

    fun findById(id: String): Optional<Book> =
        bookRepository.findById(id)

    fun insertOne(body: BookPostDto): Book {
        val book = Book(body.name, body.author)

        return bookRepository.save(book)
    }

    fun updateOne(id: String, body: BookPutDto): Book {
        val oldBook = findById(id)
            .getOrElse { throw BookNotFoundException(id) }
        val newBook = oldBook.copy(
            name = body.name ?: oldBook.name,
            author = body.author ?: oldBook.author
        )

        return bookRepository.save(newBook)
    }

    fun deleteOne(id: String) {
        bookRepository.deleteById(id)
    }

}
