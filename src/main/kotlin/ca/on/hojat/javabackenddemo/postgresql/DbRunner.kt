package ca.on.hojat.javabackenddemo.postgresql

fun main() {
    val db = DbFunctions()
    val conn = db.connectToDb("tutdb", "postgres", "perl%1coBol")

    val tableName = "students"

    // Create a [students] table.
    db.createTable(conn, "students")

    // enter first student
    db.insertRow(conn, tableName, "Hojat", "Sudbury")
    // enter second student
    db.insertRow(conn, tableName, "Hesam", "Toronto")
    // enter third student
    db.insertRow(conn, tableName, "John", "USA")

    // read all the data
    db.readData(conn, tableName)

    // update one row of the database
    db.updateName(conn, tableName, "Hojat", "The great Hojat")

    // search through the table by name
    db.searchByName(conn, tableName, "Hesam")

    // search through the table by ID
    db.searchById(conn, tableName, 3)

    // delete by name
    db.deleteRowByName(conn, tableName, "John")

    // delete by ID
    db.deleteRowById(conn, tableName, 1)

    // delete the whole table
    db.deleteTable(conn, tableName)

}