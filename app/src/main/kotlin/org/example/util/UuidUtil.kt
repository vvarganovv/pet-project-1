package org.example.util

import java.util.UUID

object UuidUtil {

    fun getUuid(): String =
        UUID.randomUUID().toString()

}