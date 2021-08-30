package tech.human.bptrk

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.boot.test.context.SpringBootTest
import tech.human.bptrk.util.Logging
import tech.human.bptrk.util.logger
import javax.transaction.Transactional

@SpringBootTest
class UserTests : Logging {

    @Autowired
    private val entityManager: TestEntityManager? = null

    @Autowired
    private val repository: UserRepository? = null

    @Test
    @Transactional
    fun givenUser_whenSaved_thenFound() {

        val testUsername = createUniqueTestUsername("test-user-2")
        val userToSave = User(username = testUsername)
        val defaultUUID = userToSave.ref

        repository?.save(userToSave)
        entityManager?.refresh(userToSave) // This gets us the DB UUID back

        Assertions.assertNotNull(userToSave.ref)
        logger().info("defaultUUID = $defaultUUID")
        logger().info("userToSave.ref => ${userToSave.ref}")

        Assertions.assertEquals(userToSave.ref, defaultUUID) // We've set a default so it should get passed in

        val userToFind = repository?.findByUsername(testUsername)

        Assertions.assertNotNull(userToFind)
        Assertions.assertEquals(testUsername, userToFind?.username)
        Assertions.assertEquals(userToSave.ref, userToFind?.ref)

    }

}

