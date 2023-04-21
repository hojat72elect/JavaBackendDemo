## Jave Backend demo

This repository is a collection of all the Java backend technologies I have worked with so far:

<ol>
<li><strong>PostgreSQL</strong></li>

The class `DbFunctions.kt` contains all the elementary operations that you can do on a SQL database via PostgreSQL.

I have created that class with help of [this](https://www.youtube.com/playlist?list=PL0vVAYYSRbD2zL7o_TBPnVAgBZmg6f4JA)
youtube tutorial.

The written code is pretty generic to any SQL database; but we have connected it to a PostgreSQL driver.

<li><strong>JDBC + H2</strong></li>

The code inside `jdbc` directory is using [H2](https://www.h2database.com/) library for connecting to a simple SQL
database.

I created this part of the demo with the help of [this](https://www.youtube.com/watch?v=KgXq2UBNEhA&t=961s) tutorial.

**No matter what kind of java database technology you're using in your server, that database will employ JDBC under the
hood.**


</ol>
