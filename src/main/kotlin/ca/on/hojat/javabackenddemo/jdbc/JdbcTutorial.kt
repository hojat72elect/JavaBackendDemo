package ca.on.hojat.javabackenddemo.jdbc

import java.sql.DriverManager
import java.sql.SQLException

class JdbcTutorial {
}

fun main(args: Array<String>) {
    try {
        DriverManager.getConnection("jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:users.sql';").use { connection ->
            println("connection is valid: ${connection.isValid(0)}")


            // CRUD operations

            // Read
            val preparedStatement = connection.prepareStatement("select * from USERS where name = ?")
            preparedStatement.setString(1, "Marco")

            val resultSet = preparedStatement.executeQuery()
            while (resultSet.next()) {
                println("${resultSet.getInt("id")} - ${resultSet.getString("name")}")
            }

        }
    } catch (e: SQLException) {
        println(e)
        throw e
    }
}