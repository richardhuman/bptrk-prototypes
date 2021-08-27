package tech.human.bptrk

import java.time.LocalDateTime
import java.time.ZoneOffset

fun createUniqueTestUsername(s: String): String {
    return "$s-${LocalDateTime.now().toEpochSecond(ZoneOffset.UTC).toString()}"
}