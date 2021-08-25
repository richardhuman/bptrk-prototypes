package tech.human.bpks

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class UserResource(val service: UserService) {
    @GetMapping
    fun index(): List<User> = service.findUsers()
}