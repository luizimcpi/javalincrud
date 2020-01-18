package com.devlhse.javalincrud

import com.devlhse.javalincrud.config.repositoryModule
import com.devlhse.javalincrud.config.serviceModule
import com.devlhse.javalincrud.constant.ApiRole
import com.devlhse.javalincrud.controller.UserController
import com.devlhse.javalincrud.exception.NotFoundException
import com.devlhse.javalincrud.security.Auth
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.security.SecurityUtil.roles
import org.koin.core.context.startKoin


class ApplicationJavalin

fun main(args: Array<String>) {
    startKoin {
        // use Koin logger
        printLogger()
        // declare modules
        modules(listOf(serviceModule, repositoryModule))
    }

    val app = Javalin.create().apply {
        accessManager(Auth::accessManager)
        exception(NotFoundException::class.java) { e, ctx ->
            ctx.status(404)
            ctx.json(mapOf("error" to e.message!!))
        }
    }.let { it.enableDebugLogging() }
        .start(7000)

    app.routes {

        path("users") {
            get(UserController::getAllUsers, roles(ApiRole.ANYONE))
            post(UserController::createUser, roles(ApiRole.ANYONE))
            path(":user-id") {
                get(UserController::getUser, roles(ApiRole.USER_READ))
                patch(UserController::updateUser, roles(ApiRole.USER_WRITE))
                delete(UserController::deleteUser, roles(ApiRole.USER_WRITE))
            }
        }
    }
}

