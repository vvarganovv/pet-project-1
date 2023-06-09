package org.example.model

import org.example.util.UuidUtil
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("books")
data class Book(
    @Id
    val id: String,
    val name: String,
    val author: String
) {

    constructor(name: String, author: String) : this(UuidUtil.getUuid(), name, author)

}