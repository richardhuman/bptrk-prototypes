package tech.human.bptrk

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import tech.human.bptrk.util.Logging
import tech.human.bptrk.util.logger
import java.util.*

@RestController
class ReadingResource(val service: ReadingService) {

    @GetMapping("/readings/{userRef}")
    fun findAllReadingsByUserRef(@PathVariable userRef: UUID): List<BloodPressureReading> {
        return service.findAllReadingsByUserRef(userRef)
    }

}