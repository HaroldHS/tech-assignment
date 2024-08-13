# tech-assignment

### Requirements
* Java 17
* MySQL

### Database Setup
1. Create a database in the MySQL server
```
C://> mysql -u root -p
Enter password: ***
mysql> CREATE DATABASE test_db;
mysql> exit
```
2. Update **application.properties** in `/src/main/resources`
    1. Replace string "*test_db*" in `spring.datasource.url` with database name created in step 1
    2. Replace mysql server username in `spring.datasource.username` with the username of your mysql server
    3. Replace mysql server password in `spring.datasource.password` with the password of your mysql server

### How to run
Before running the program, make sure that the database configuration is valid (look at "Database Setup" section), then run the code below in terminal / command prompt:
```bash
./gradlew bootRun # linux

# or #

gradlew.bat booRun # windows
```

Then, open **http://localhost:8080** in a browser.

> Note: This program uses Spring Security by default, as a result, at first, the page will be redirected to `/login`. In order to insert the credential, the username is **user** and the password is given when running `gradlew bootRun` (find this sentence/string in the terminal/command prompt: **"Using generated security password: XXXXXXXXXXXXXX"**)
