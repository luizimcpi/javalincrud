package com.devlhse.javalincrud.service.impl

import com.devlhse.javalincrud.service.EmailService
import io.javalin.Context
import org.apache.commons.mail.DefaultAuthenticator
import org.apache.commons.mail.SimpleEmail

class EmailServiceImpl: EmailService {
    override fun sendEmail(ctx: Context, name: String) {
        SimpleEmail().apply {
            setHostName("smtp.live.com")
            setSmtpPort(587)
            setStartTLSEnabled(true)
            setAuthenticator(DefaultAuthenticator("user@hotmail.com", "password"))
            setFrom("user@hotmail.com")
            setSubject("Javalin User API")
            setMsg("User with name: $name has been created by javalin API")
            addTo("teste@email.com")
        }.send()
    }
}