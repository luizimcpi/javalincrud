package com.devlhse.javalincrud.config

import com.devlhse.javalincrud.repository.UserRepository
import com.devlhse.javalincrud.repository.impl.UserRepositoryImpl
import com.devlhse.javalincrud.service.EmailService
import com.devlhse.javalincrud.service.impl.EmailServiceImpl
import org.koin.dsl.module

val serviceModule = module {

    single { EmailServiceImpl() as EmailService }
}


val repositoryModule = module {

    single { UserRepositoryImpl() as UserRepository }
}