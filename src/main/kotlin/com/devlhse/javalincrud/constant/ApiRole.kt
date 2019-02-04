package com.devlhse.javalincrud.constant

import io.javalin.security.Role

enum class ApiRole : Role { ANYONE, USER_READ, USER_WRITE }