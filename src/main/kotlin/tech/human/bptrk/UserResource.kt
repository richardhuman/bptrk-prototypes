package tech.human.bptrk

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import tech.human.bptrk.util.Logging
import tech.human.bptrk.util.logger
import java.util.*


@RestController
class UserResource(val service: UserService) : Logging {

    @GetMapping("/users")
    fun index(): MutableIterable<User> = service.findUsers()

    @GetMapping("/users/{ref}")
    fun findByRef(@PathVariable ref: UUID): User?  {
        val user = service.findByRef(ref)
        val readings = user?.bloodPressureReadings?.joinToString()
        logger().info("[UserResource] $ref => ${user?.username} => $readings")
        return user
    }
}