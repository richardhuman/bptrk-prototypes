package tech.human.bptrk

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.NaturalId
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

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
    val id: Int = 0,

    @Column(columnDefinition = "uuid", unique = true, updatable = false, insertable = false)
    val ref: UUID = UUID.randomUUID(),

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @NaturalId
    @Column(nullable = false, unique = true)
    val username: String,

) {

    @Column(name = "full_name")
    var fullName: String? = ""

    @Column(name = "updated_at", insertable = false)
    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JsonIgnore
    val bloodPressureReadings: Set<BloodPressureReading> = emptySet()

}
