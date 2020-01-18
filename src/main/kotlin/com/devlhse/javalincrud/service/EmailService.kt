package com.devlhse.javalincrud.service

import io.javalin.Context

interface EmailService {
    fun sendEmail(ctx: Context, name: String)
}