package com.devlhse.javalincrud.repository.impl

import com.devlhse.javalincrud.model.User
import com.devlhse.javalincrud.repository.UserRepository

class UserRepositoryImpl: UserRepository {
    override fun findAll(): List<User> {
        return listOf(User("Luiz Henrique", "luizhse@yahoo.com.br", 1))
    }
}