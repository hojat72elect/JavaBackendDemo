## Jave Backend demo

This repository is a collection of all the Java backend technologies I have worked with so far:

<ol>
<li><strong>PostgreSQL</strong></li>

The class [DbFunctions.kt] contains all the elementary operations that you can do on a SQL database via PostgreSQL.

I have created that class with help of [this](https://www.youtube.com/playlist?list=PL0vVAYYSRbD2zL7o_TBPnVAgBZmg6f4JA)
youtube tutorial.

This is the common kotlin code for connecting to a PostgreSQL database:

```
val db = DbFunctions()

val conn = db.connectToDb("tutdb", "postgres", "perl%1coBol")
```

<li><strong>JavaFX + SQLite</strong></li>

The code inside `school_system` is a demo SQLite database with a frontend written in JavaFX.

The tutorial I'm following for this one is [this](https://www.youtube.com/watch?v=h1rYlMrvNyE).

</ol>
