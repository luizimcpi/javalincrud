# javalin-crud

```
A simple CRUD using the javalin framework and kotlin
```
[JAVALIN](https://javalin.io/)


## Start Application

```
Docker

In the project directory run the following commands

1 -> ./gradlew build
2 -> docker build -t javalincrud .
3 -> docker-compose up
```

```
Only Gradle

1 -> ./gradlew build
2 -> java -jar build/libs/javalincrud-0.0.1-SNAPSHOT.jar
```

## Endpoints

*List Users

```
GET http://localhost:7000/users
```
*Create User

```
POST http://localhost:7000/users
Body

{
	"name": "Luiz",
	"email": "teste@email.com"
}

***Use Basic Auth for next endpoints
```
username: alice
password: better-password
```

```
*GET Specific User by ID

```
GET http://localhost:7000/users/{id}
{id} => 1,2,3...
```

*DELETE User

```
DELETE http://localhost:7000/users/{id}
{id} => 1,2,3...
```

*PATCH

```
PATCH http://localhost:7000/users/{id}
Body
{
    "name": "Bob Dylan",
    "email": "bob_dylan@bob.kt",
    "id": 1
}
```



