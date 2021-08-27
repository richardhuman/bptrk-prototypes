package tech.human.bptrk

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "blood_pressure_readings")
class BloodPressureReading(

    @Id
    @SequenceGenerator(
        name = "id_blood_pressure_readings_id_seq",
        sequenceName = "id_blood_pressure_readings_id_seq",
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_blood_pressure_readings_id_seq")
    var id: Int = 0,

    @Column(unique = true, columnDefinition = "uuid", updatable = false)
    var ref: UUID,

    @Column(nullable = false, name = "created_at", updatable = false)
    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    var user: User,

    @Column(name = "systolic", nullable = false)
    val systolic: Int,

    @Column(name = "diastolic", nullable = false)
    val diastolic: Int,

    @Column(name = "pulse_rate", nullable = false)
    val pulseRate: Int,

    ) {

    @Column(nullable = false, name = "updated_at", updatable = false)
    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null

    @Column
    var notes: String? = null

    override fun toString() : String {
        return "[BP: $systolic/$diastolic - $pulseRate]"
    }
}