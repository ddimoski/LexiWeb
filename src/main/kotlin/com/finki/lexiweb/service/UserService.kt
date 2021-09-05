package com.finki.lexiweb.service

import com.finki.lexiweb.domain.Role
import com.finki.lexiweb.domain.User
import com.finki.lexiweb.domain.enums.RoleEnum
import com.finki.lexiweb.dto.UserDTO
import com.finki.lexiweb.repository.UserRepository
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import javax.transaction.Transactional

@Service
class UserService (private val userRepository: UserRepository) : UserDetailsService {

    fun getById(id: Long) = userRepository.getById(id)

    fun register(request: UserDTO): User {
        if (request.firstName == null || request.lastName == null || request.email == null || request.dateOfBirth == null) {
            throw RuntimeException("Error: Cannot register user.")
        }
        val roles = HashSet<Role>()
        roles.add(Role(RoleEnum.USER))
        val user = User(request.username, request.password, request.firstName, request.lastName, request.email,
        roles, request.dateOfBirth)
        userRepository.save(user)
        return user
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        TODO("Not yet implemented")
    }
}