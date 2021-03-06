/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package tech.human.bptrk

import java.sql.DriverManager
import org.jooq.*
import org.jooq.impl.*
import tech.human.bptrk.jooq.generated.Tables
import tech.human.bptrk.jooq.generated.tables.records.*

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }

    fun runJooq() {
        val userName = "bptrk_dev"
        val password = "bptrk_dev"
        val url = "jdbc:postgresql://localhost/bptrk_kt_spring"
        try {
            DriverManager.getConnection(url, userName, password).use { conn ->
                val create: DSLContext = DSL.using(conn, SQLDialect.POSTGRES)
                val results: Result<UserRecord> = create.selectFrom(Tables.USER).fetch()
                for (r: UserRecord in results) {
                    val name = r.username
                    val ref = r.ref
                    val id = r.id

                    println("User: $id / $ref / $name")

                }
                println("DB goodness here")
            }
        }
        catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

fun main() {
    App().runJooq()
}
