package ca.on.hojat.javabackenddemo.postgresql

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

class DbFunctions {

    /**
     * For connecting to our database.
     */
    fun connectToDb(
        dbName: String,
        user: String,
        pass: String
    ): Connection {

        var conn: Connection? = null
        try {
            Class.forName("org.postgresql.Driver")
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/$dbName", user, pass)

            if (conn == null) {
                println("Connection failed")
            } else {
                println("Connection was established")
            }


        } catch (e: Exception) {
            println(e)

        }
        return conn!!
    }

    /**
     * Creates a table named "students" with 3 columns.
     * 1- student_id
     * 2- name
     * 3- address
     */
    fun createTable(
        conn: Connection,
        tableName: String
    ) {
        try {
            val query =
                "create table $tableName(student_id SERIAL,name varchar(200),address varchar(200),primary key(student_id));"

            // It's going to be our cursor to this db
            val statement = conn.createStatement()

            statement.executeUpdate(query)
            println("Table was created successfully")

        } catch (e: Exception) {
            println(e)
            throw e
        }
    }

    /**
     * It will add a new row into our "employee" table which contains "name" and "address" columns.
     */
    fun insertRow(
        conn: Connection,
        tableName: String,
        name: String,
        address: String
    ) {
        try {
            val query = "insert into $tableName(name,address) values('$name','$address');"
            val statement = conn.createStatement()
            statement.executeUpdate(query)
            println("The new row was successfully inserted into db")
        } catch (e: Exception) {
            println(e)
        }

    }

    /**
     * @param tableName : read and print out everything inside this table.
     */
    fun readData(conn: Connection, tableName: String) {
        val statement: Statement
        val rs: ResultSet?

        try {
            val query = "select * from $tableName"
            statement = conn.createStatement()
            rs = statement.executeQuery(query)
            while (rs.next()) {
                print(rs.getString("empid") + " ")
                print(rs.getString("name") + " ")
                println(rs.getString("Address") + " ")
            }

        } catch (e: Exception) {
            println(e)
            throw e
        }
    }

    /**
     * It only updates the name column of a given row.
     */
    fun updateName(
        conn: Connection,
        tableName: String,
        oldName: String,
        newName: String
    ) {

        val statement: Statement
        try {
            val query = "update $tableName set name='$newName' where name='$oldName'"
            statement = conn.createStatement()
            statement.executeUpdate(query)
            println("The 'name' column of $tableName table was updated")
        } catch (e: Exception) {
            println(e)
            throw e
        }


    }

    /**
     * Searches through the table according to 'name' column.
     *
     * @param tableName the table to be searched through.
     */
    fun searchByName(
        conn: Connection,
        tableName: String,
        name: String
    ) {
        val statement: Statement
        val rs: ResultSet?

        try {
            val query = "select * from $tableName where name= '$name'"
            statement = conn.createStatement()
            rs = statement.executeQuery(query)
            while (rs.next()) {
                print(rs.getString("empid") + " ")
                print(rs.getString("name") + " ")
                println(rs.getString("address"))
            }

        } catch (e: Exception) {
            println(e)
            throw e
        }

    }

    /**
     * Pretty much like [searchByName] but searches according to id
     */
    fun searchById(
        conn: Connection,
        tableName: String,
        id: Int
    ) {
        val statement: Statement
        val rs: ResultSet?

        try {
            val query = "select * from $tableName where empid= '$id'"
            statement = conn.createStatement()
            rs = statement.executeQuery(query)
            while (rs.next()) {
                print(rs.getString("empid") + " ")
                print(rs.getString("name") + " ")
                println(rs.getString("address"))
            }

        } catch (e: Exception) {
            println(e)
            throw e
        }

    }

    /**
     * you provide the name of the rows you want to be deleted.
     */
    fun deleteRowByName(
        conn: Connection,
        tableName: String,
        name: String
    ) {
        val statement: Statement

        try {
            val query = "delete from $tableName where name='$name'"
            statement = conn.createStatement()
            statement.executeUpdate(query)
            println("The data row was deleted successfully")
        } catch (e: Exception) {
            println(e)
            throw e
        }

    }

    /**
     * pretty much like [deleteRowByName] but it deletes according to empid
     */
    fun deleteRowById(
        conn: Connection,
        tableName: String,
        id: Int
    ) {
        val statement: Statement

        try {
            val query = "delete from $tableName where empid='$id'"
            statement = conn.createStatement()
            statement.executeUpdate(query)
            println("The data row was deleted successfully")
        } catch (e: Exception) {
            println(e)
            throw e
        }

    }

    /**
     * Deletes a given table altogether.
     */
    fun deleteTable(conn: Connection, tableName: String) {
        val statement: Statement
        try {
            val query = "drop table $tableName"
            statement = conn.createStatement()
            statement.executeUpdate(query)
            println("Table was deleted successfully")
        } catch (e: Exception) {
            println(e)
            throw e
        }


    }
}