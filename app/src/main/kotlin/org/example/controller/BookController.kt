package org.example.controller

import org.example.model.Book
import org.example.model.dto.BookPostDto
import org.example.service.BookService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/book")
class BookController(
    val bookService: BookService
) {

    @GetMapping
    fun findAll(pageable: Pageable): Page<Book> =
        bookService.findAll(pageable)

    @PostMapping
    fun insert(@RequestBody body: BookPostDto) =
        bookService.insertOne(body)

}