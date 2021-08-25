package tech.human.bpks

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {

    fun findByUsername(username: String): User?

    @Query(value = "select * from users", nativeQuery = true)
    fun findUsers(): List<User>
}