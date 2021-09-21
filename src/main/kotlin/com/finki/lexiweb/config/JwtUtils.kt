package com.finki.lexiweb.config

import com.finki.lexiweb.domain.UserPrincipal
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.UnsupportedJwtException
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.security.SignatureException
import java.util.*
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

@Component
class JwtUtils(
    @Value("\${lexiweb.app.jwtSecret}")
    private val jwtSecret: String,

    @Value("\${lexiweb.app.jwtExpirationMs}")
    private val jwtExpirationMs: Long
) {
    private val KEY: SecretKey = SecretKeySpec(jwtSecret.toByteArray(), "HmacSHA512")

    fun generateJwtToken(authentication: Authentication): String {
        val userPrincipal: UserPrincipal = authentication.principal as UserPrincipal

        return Jwts.builder()
            .setSubject(userPrincipal.username)
            .setIssuedAt(Date())
            .setExpiration(Date(Date().time + jwtExpirationMs))
            .signWith(KEY)
            .compact()
    }

    fun getUsernameFromToken(token: String): String = Jwts.parserBuilder()
        .setSigningKey(KEY)
        .build()
        .parseClaimsJws(token)
        .body
        .subject


    fun validateJwtToken(authToken: String): Boolean {
        try {
            Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(authToken)
            return true

        } catch (e: SignatureException) {
            e.printStackTrace()
        } catch (e: MalformedJwtException) {
            e.printStackTrace()
        } catch (e: ExpiredJwtException) {
            e.printStackTrace()
        } catch (e: UnsupportedJwtException) {
            e.printStackTrace()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
        return false
    }
}