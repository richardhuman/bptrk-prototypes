package tech.human.bptrk

import org.springframework.stereotype.Service
import tech.human.bptrk.util.ResourceNotFoundException
import java.util.*


@Service
class ReadingService(val db : ReadingRepository, val userDb : UserRepository) {

    fun findAllReadingsByUserRef(userRef: UUID): List<BloodPressureReading> = db.findAllReadingsByUserRef(userRef)

    fun createReading(userRef: UUID, reading: BloodPressureReading) {
        val user = userDb.findByRef(userRef) ?: throw ResourceNotFoundException("User ref $userRef not found.")
        reading.user = user
        db.save(reading)
    }
}