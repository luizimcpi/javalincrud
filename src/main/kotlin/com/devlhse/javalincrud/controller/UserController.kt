package com.devlhse.javalincrud.controller

import com.devlhse.javalincrud.repository.UserInMemoryDao
import com.devlhse.javalincrud.exception.NotFoundException
import com.devlhse.javalincrud.repository.UserRepository
import com.devlhse.javalincrud.service.EmailService
import io.javalin.Context
import org.koin.core.KoinComponent
import org.koin.core.inject

object UserController: KoinComponent {

    private val userDao = UserInMemoryDao()
    private val userRepository by inject<UserRepository>()
    private val emailService by inject<EmailService>()

    fun getAllUsers(ctx: Context) {
        ctx.json(userRepository.findAll())
    }

    fun createUser(ctx: Context) {
        val user = ctx.body<com.devlhse.javalincrud.model.User>()
        userDao.save(name = user.name, email = user.email)
        ctx.status(201)
        emailService.sendEmail(ctx, user.name)
    }

    fun getUser(ctx: Context) {
        try {
            ctx.json(userDao.findById(ctx.pathParam("user-id").toInt())!!)
        } catch (e: Exception) {
            throw NotFoundException("Car Not Found")
        }
    }

    fun updateUser(ctx: Context) {
        val user = ctx.body<com.devlhse.javalincrud.model.User>()
        userDao.update(
            id = ctx.pathParam("user-id").toInt(),
            user = user
        )
        ctx.status(204)
    }

    fun deleteUser(ctx: Context) {
        userDao.delete(ctx.pathParam("user-id").toInt())
        ctx.status(204)
    }

}