package tech.human.bptrk

import org.springframework.stereotype.Repository
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.TypedQuery

@Repository
class ReadingByUserRepositoryImpl : ReadingByUserRepository {

    @PersistenceContext
    lateinit var em: EntityManager

    override fun findAllReadingsByUserRef(userRef: UUID): List<BloodPressureReading> {

        val query: TypedQuery<BloodPressureReading> =
            em.createQuery("""
                SELECT bp 
                FROM BloodPressureReading bp
                JOIN User u on u = bp.user
                WHERE u.ref = :userRef
            """.trimIndent(), BloodPressureReading::class.java)

        return query.setParameter("userRef", userRef).resultList
    }

}