package tech.human.bptrk

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

@SpringBootTest
class UserTests {

    @Autowired
    private val entityManager: TestEntityManager? = null

    @Autowired
    private val repository: UserRepository? = null

    @Test
    @Transactional
    fun givenUser_whenSaved_thenFound() {

        val testUsername = "test-user-2"
        val userToSave = User(username = testUsername)
        val defaultUUID = userToSave.ref

        repository?.save(userToSave)
        entityManager?.refresh(userToSave) // This gets us the DB UUID back

        Assertions.assertNotNull(userToSave.ref)
        println(defaultUUID)
        println(userToSave.ref)
        Assertions.assertNotEquals(userToSave.ref, defaultUUID)

        val userToFind = repository?.findByRef(userToSave.ref)

        Assertions.assertEquals(userToSave.ref, userToFind?.ref)
        Assertions.assertEquals(testUsername, userToFind?.username)

    }

    @Test
//    @Transactional
    fun givenUser_whenSaved_thenUpdateStamped() {

        val testUsername = createUniqueTestUsername("test-user-3")
        val userToSave = User(username = testUsername)
        val userSaved = repository?.save(userToSave)
        entityManager?.refresh(userToSave)

        Assertions.assertNotNull(userToSave.updatedAt)
        val updateTimestamp1 = userToSave.updatedAt

        userToSave.fullName = "Richard Test"
        repository?.save(userToSave)
        entityManager?.refresh(userToSave)
        val updateTimestamp2 = userToSave.updatedAt

        Assertions.assertNotEquals(updateTimestamp1, updateTimestamp2)

    }
}

