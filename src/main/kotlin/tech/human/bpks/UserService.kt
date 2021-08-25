package tech.human.bpks

import org.springframework.stereotype.Service

@Service
class UserService(val db: UserRepository) {
    fun findUsers(): List<User> = db.findUsers()
}