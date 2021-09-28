package com.finki.lexiweb.controller

import com.finki.lexiweb.config.JwtUtils
import com.finki.lexiweb.domain.User
import com.finki.lexiweb.domain.UserPrincipal
import com.finki.lexiweb.dto.ChangePasswordDTO
import com.finki.lexiweb.dto.JwtDTO
import com.finki.lexiweb.dto.UserDTO
import com.finki.lexiweb.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api/user")
class UserController(private val userService: UserService,
                     private val authenticationManager: AuthenticationManager,
                     private val jwtUtils: JwtUtils,
                     private val passwordEncoder: PasswordEncoder
) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = userService.getById(id)

    @PostMapping("/register")
    fun registerUser(@RequestBody registerRequest: UserDTO): ResponseEntity<UserDTO> {
        val userDto = UserDTO(null, registerRequest.username, passwordEncoder.encode(registerRequest.password),
        registerRequest.email, registerRequest.firstName, registerRequest.lastName, registerRequest.dateOfBirth)
        val user = userService.register(userDto)
        return ResponseEntity.ok(UserDTO(user.id, user.username, user.password, user.email, user.firstName, user.lastName,
        user.dateOfBirth))
    }

    @PostMapping("/login")
    fun authenticateUser(@RequestBody loginRequest: UserDTO): ResponseEntity<JwtDTO> {
        val authentication = authenticationManager
            .authenticate(UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password))
        SecurityContextHolder.getContext().authentication = authentication
        val jwt = jwtUtils.generateJwtToken(authentication)
        val userDetails = userService.loadUserByUsername(loginRequest.username)
        val user: User = userService.findByUsername(loginRequest.username)
        val role: String = userDetails.authorities.stream().findFirst().get().toString()

        return ResponseEntity.ok(JwtDTO(jwt, user.id, user.username, user.email, role))
    }

}