package ca.on.hojat.javabackenddemo.jdbc

import com.zaxxer.hikari.HikariDataSource
import java.sql.SQLException
import javax.sql.DataSource


fun main() {
    try {
        val dataSource = createDataSource()

        dataSource.connection.use { connection ->
            println("connection is valid: ${connection.isValid(0)}")


            // CRUD operations

            // Read
            val preparedStatement = connection.prepareStatement("select * from USERS where name = ?")
            preparedStatement.setString(1, "Marco")

            val resultSet = preparedStatement.executeQuery()
            while (resultSet.next()) {
                println("${resultSet.getInt("id")} - ${resultSet.getString("name")}")
            }

            // Insert
            val insertPreparedStatement = connection.prepareStatement("insert into USERS (name) values (?)")
            insertPreparedStatement.setString(1, "John")
            val insertCount = insertPreparedStatement.executeUpdate()
            println("insert count = $insertCount")

            // update
            val updatePs = connection.prepareStatement("update USERS set name = ? where name = ?")
            updatePs.setString(1, "Johnny")
            updatePs.setString(2, "John")
            val updateCount = updatePs.executeUpdate()
            println("update count = $updateCount")

            // Delete
            val deletePs = connection.prepareStatement("delete from USERS where name = ?")
            deletePs.setString(1, "Johnny")
            val deleteCount = deletePs.executeUpdate()
            println("delete count = $deleteCount")

        }
    } catch (e: SQLException) {
        println(e)
        throw e
    }
}

private fun createDataSource(): DataSource {
    // make a hikari connection pool and return a datasource to it.
    val dataSource = HikariDataSource()
    dataSource.jdbcUrl = "jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:users.sql';"
    return dataSource
}














