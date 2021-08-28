package com.finki.lexiweb.controller

import com.finki.lexiweb.service.UserService
import org.springframework.stereotype.Controller

@Controller
class UserController(private val userService: UserService) {
}