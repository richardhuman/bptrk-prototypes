package tech.human.bptrk

import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(val db: UserRepository) {

    fun findByRef(ref: UUID): User? = db.findByRef(ref)
    fun findByUsername(username: String): User? = db.findByUsername(username)
    fun findUsers(): MutableIterable<User> = db.findAll()

}