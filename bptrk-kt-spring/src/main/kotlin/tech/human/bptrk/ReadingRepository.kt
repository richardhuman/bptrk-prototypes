package tech.human.bptrk

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ReadingRepository : CrudRepository<BloodPressureReading, Long>, ReadingByUserRepository

interface ReadingByUserRepository {
    fun findAllReadingsByUserRef(userRef: UUID): List<BloodPressureReading>
}