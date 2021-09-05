package com.finki.lexiweb.controller

import com.finki.lexiweb.dto.ChangePasswordDTO
import com.finki.lexiweb.dto.UserDTO
import com.finki.lexiweb.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api/user")
class UserController(private val userService: UserService) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = userService.getById(id)

    @PostMapping("/register")
    fun register(@RequestBody request: UserDTO) = userService.register(request)

//    @PostMapping("/login")
//    fun login(@RequestBody request: UserDTO) = userService.login(request)

//    @PostMapping("/{id}/change-password")
//    fun changePassword(@PathVariable id: Long, request: ChangePasswordDTO) = userService.changePassword(id, request)


}