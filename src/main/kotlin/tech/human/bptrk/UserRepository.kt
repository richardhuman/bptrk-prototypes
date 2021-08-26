package tech.human.bptrk

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<User, Long> {

    fun findByRef(ref: UUID): User?
    fun findByUsername(username: String): User?

}