package com.finki.lexiweb.service

import com.finki.lexiweb.domain.Role
import com.finki.lexiweb.domain.User
import com.finki.lexiweb.domain.UserPrincipal
import com.finki.lexiweb.domain.enums.RoleEnum
import com.finki.lexiweb.dto.UserDTO
import com.finki.lexiweb.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import kotlin.RuntimeException

@Service
class UserService (private val userRepository: UserRepository) : UserDetailsService {

    fun getById(id: Long) = userRepository.getById(id)

    fun register(request: UserDTO): User {
        if (request.firstName == null || request.lastName == null || request.email == null || request.dateOfBirth == null) {
            throw RuntimeException("Грешка: Не се сите полиња пополнети.")
        }
        if (userRepository.existsByUsername(request.username)) {
            throw RuntimeException("Грешка: Корисничкото име веќе постои. Одбери ново.")
        }
        if (userRepository.existsByEmail(request.email)) {
            throw RuntimeException("Грешка: Електронската адреса веќе е во употреба со постоечки профил.")
        }
        val roles = HashSet<Role>()
        roles.add(Role(RoleEnum.USER))
        val user = User(request.username, request.password, request.firstName, request.lastName,
                        request.email, roles, request.dateOfBirth)
        userRepository.save(user)
        return user
    }

    override fun loadUserByUsername(username: String): UserPrincipal {
        if (userRepository.existsByUsername(username))
            return UserPrincipal(userRepository.findByUsername(username))
        else
            throw RuntimeException("Can't find user with username $username in the database")
    }

    fun findByUsername(username: String): User = userRepository.findByUsername(username)
}