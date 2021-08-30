package tech.human.bptrk

import org.hibernate.SessionFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.orm.hibernate5.SessionFactoryUtils
import javax.transaction.Transactional

@SpringBootTest
class BloodPressureReadingTest {

    @Autowired private val userRepository: UserRepository? = null
    @Autowired private val readingRepository: ReadingRepository? = null

    @Test
    @Transactional
    fun givenUser_whenReadingsAdded_thenFound() {

        val testUsername = createUniqueTestUsername("test-user-bp-1")
        val bpUser = User(username = testUsername)
        userRepository?.save(bpUser)


        val reading1 = BloodPressureReading(systolic = 120, diastolic = 80, pulseRate = 60)
        reading1.user = bpUser
        readingRepository?.save(reading1)

        val userToCheck = userRepository?.findByUsername(testUsername)
        Assertions.assertEquals(1, userToCheck?.bloodPressureReadings?.size)

        val reading2 = BloodPressureReading(systolic = 130, diastolic = 90, pulseRate = 70)
        reading2.user = bpUser
        readingRepository?.save(reading2)

        val bpReadings = readingRepository?.findAllReadingsByUserRef(bpUser.ref)
        Assertions.assertEquals(2, bpReadings?.size)
        Assertions.assertNotEquals(bpReadings?.get(0)?.createdAt, bpReadings?.get(1)?.createdAt)
        Assertions.assertNotEquals(bpReadings?.get(0)?.ref, bpReadings?.get(1)?.ref)
    }

    @Test
    @Transactional
    fun givenUser_whenReadingsSaved_thenLoadedByProxy() {

        val testUsername = createUniqueTestUsername("test-user-bp-1")
        val bpUser = User(username = testUsername)
        userRepository?.save(bpUser)

        val reading1 = BloodPressureReading(systolic = 120, diastolic = 80, pulseRate = 60)
        reading1.user = bpUser
        readingRepository?.save(reading1)

        val userToCheck = userRepository?.findByUsername(testUsername)!!
        Assertions.assertEquals(1, userToCheck.bloodPressureReadings.size)

    }
}