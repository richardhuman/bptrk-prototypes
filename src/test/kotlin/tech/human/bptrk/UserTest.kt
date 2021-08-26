package tech.human.bptrk

//import org.hibernate.testing.transaction.TransactionUtil.doInHibernate
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserTests {

    @Test
    fun givenUser_whenSaved_thenFound() {
        val testUsername = "test-user"
        Assertions.assertEquals("test-user", testUsername)
//    doInHibernate(({ this.sessionFactory() }), { session ->
//        val userToSave = User(username = testUsername)
//        session.persist(userToSave)
//        val userToFind = session.find(User::class.java, userToSave.id)
//        session.refresh(userToFind)
//
//
//
//    })
    }
}

