package tech.human.bptrk

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.*
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "users")
class User(

    @Id
    @SequenceGenerator(
        name = "id_users_id_seq",
        sequenceName = "id_users_id_seq",
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_users_id_seq")
    val id: Long = 0,

    @Column(columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    var ref: UUID = UUID.randomUUID(),

    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @NaturalId
    @Column(nullable = false, unique = true)
    val username: String,

    ) {

    @Column(name = "full_name")
    var fullName: String? = ""

    @Column(name = "updated_at", insertable = false)
    var updatedAt: LocalDateTime? = null

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
//    @JsonIgnore
    val bloodPressureReadings: Set<BloodPressureReading> = emptySet()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (username != other.username) return false

        return true
    }

    override fun hashCode(): Int {
        return username.hashCode()
    }


}
