package tech.human.bpks

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

    @Column(nullable = false)
    val username: String
) {

}