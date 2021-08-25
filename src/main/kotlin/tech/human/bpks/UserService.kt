package tech.human.bpks

import org.springframework.stereotype.Service

@Service
class UserService(val db: UserRepository) {
    fun findByUsername(username: String): User? {
        return db.findByUsername(username)
    }
    fun findUsers(): List<User> = db.findUsers()
}