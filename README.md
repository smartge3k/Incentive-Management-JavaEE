`Instructions`

1.  Download `postgresql-42.2.9`  from the following link https://jdbc.postgresql.org/download.html 
2. Copy and past the file in `glassFish` `%GlassFish Location in your pc%`/glassfish\domains\domain1\lib
3. Create `user` [`username: tester` `Password: tester`] with `can_login true` previliges.
4. Create `BeverageStore` database with owner tester.
5. Check settings in `gradle.properties`, especially the path to Glassfish

6. In the project's root folder:
Run target `gradlew startGlassfish`
Run target `gradlew initServer`
Run target `gradlew build`
Run target `gradlew deploy`
Follow the following Links to use the application.

7. Execute `resources/db_tables.sql` inside pgAdmin to add some data before running. (Only do it after deploy as it persistence.xml aut generates the tables everytime its executed)


`http://localhost:8080/frontend/incentiveservlet`
`http://localhost:8080/frontend/beverages`
`http://localhost:8080/frontend/orderservlet`

Note:
-Please always refere to the server log if you do not see expected output.

