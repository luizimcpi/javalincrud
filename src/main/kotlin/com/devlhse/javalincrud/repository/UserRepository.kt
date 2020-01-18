package com.devlhse.javalincrud.repository

import com.devlhse.javalincrud.model.User

interface UserRepository {
    fun findAll(): List<User>
}