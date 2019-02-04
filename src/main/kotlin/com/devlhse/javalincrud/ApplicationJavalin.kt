package com.devlhse.javalincrud

import com.devlhse.javalincrud.controller.UserController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*

class ApplicationJavalin

fun main(args: Array<String>) {
    val app = Javalin.create().apply {
        exception(Exception::class.java) { e, ctx -> e.printStackTrace() }
        error(404) { ctx -> ctx.json("not found") }
    }.start(7000)

    app.routes {

        path("users") {
            get(UserController::getAllUsers)
            post(UserController::createUser)
            path(":user-id") {
                get(UserController::getUser)
                patch(UserController::updateUser)
                delete(UserController::deleteUser)
            }
            path(":email") {
                get(UserController::getUserByEmail)
            }
        }
    }
}
