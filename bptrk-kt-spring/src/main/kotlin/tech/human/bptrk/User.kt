package tech.human.bptrk

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
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
    val id: Int,

    @Column(unique = true, columnDefinition = "uuid", updatable = false)
    val ref: UUID,

    @Column(nullable = false, name = "created_at", updatable = false)
    @CreationTimestamp
    val createdAt: LocalDateTime,

    @Column(nullable = false, name = "updated_at", updatable = false)
    @UpdateTimestamp
    val updatedAt: LocalDateTime,

    @Column(nullable = false, unique = true)
    val username: String,

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JsonIgnore
    val bloodPressureReadings: Set<BloodPressureReading>

) {}
