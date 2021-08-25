package tech.human.bpks

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class UserResource(val service: UserService) {
    @GetMapping
    fun index(): List<User> = service.findUsers()

    @GetMapping("/users/{username}")
    fun findByUsername(@PathVariable username: String): User? = service.findByUsername(username)
}