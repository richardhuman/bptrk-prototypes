package tech.human.bptrk

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import tech.human.bptrk.util.Logging
import tech.human.bptrk.util.ResourceNotFoundException
import tech.human.bptrk.util.logger
import java.util.*

@RestController
class ReadingResource(val service: ReadingService) {

    @GetMapping("/readings/{userRef}")
    fun findAllReadingsByUserRef(@PathVariable userRef: UUID): List<BloodPressureReading> {
        return service.findAllReadingsByUserRef(userRef)
    }

    @PostMapping("/readings/{userRef}")
    fun createReading(@PathVariable userRef: UUID, @RequestBody reading: BloodPressureReading) {
        try {
            service.createReading(userRef, reading)
        } catch (exc: ResourceNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, exc.message)
        }
    }

}