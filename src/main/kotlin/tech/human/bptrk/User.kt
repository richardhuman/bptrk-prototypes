package tech.human.bptrk

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id
    @SequenceGenerator(name="idusers_id_seq",
                        sequenceName="idusers_id_seq",
                        allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="idusers_id_seq")
    val id: Int,

    @Column(unique = true, columnDefinition = "uuid", updatable = false)
    val ref: UUID,

    @Column(nullable = false, unique = true)
    val username: String
) { }
