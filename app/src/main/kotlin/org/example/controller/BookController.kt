package org.example.controller

import org.example.model.Book
import org.example.model.dto.BookPostDto
import org.example.model.dto.BookPutDto
import org.example.service.BookService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/book")
class BookController(
    val bookService: BookService
) {

    @GetMapping
    fun findAll(pageable: Pageable): List<Book> =
        bookService.findAll(pageable)

    @PostMapping
    fun insert(@RequestBody body: BookPostDto) =
        bookService.insertOne(body)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody body: BookPutDto) =
        bookService.updateOne(id, body)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) =
        bookService.deleteOne(id)

}