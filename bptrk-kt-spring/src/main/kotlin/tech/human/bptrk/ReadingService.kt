package tech.human.bptrk

import org.springframework.stereotype.Service
import java.util.*

@Service
class ReadingService(val db : ReadingRepository) {
    fun findAllReadingsByUserRef(userRef: UUID): List<BloodPressureReading> = db.findAllReadingsByUserRef(userRef)
}