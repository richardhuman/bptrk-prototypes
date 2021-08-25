package tech.human.bpks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BpksApplication

fun main(args: Array<String>) {
	runApplication<BpksApplication>(*args)
}
