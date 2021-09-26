package com.finki.lexiweb.config

import com.finki.lexiweb.service.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig(val userService: UserService,
                        val unauthorizedHandler: AuthEntryPointJwt,
                        val jwtUtils: JwtUtils) : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder())
    }

    override fun configure(http: HttpSecurity) {
        http.cors().and().csrf().disable()
            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests().antMatchers("*").permitAll()
//            .authorizeRequests().antMatchers("/api/account/**").permitAll()
//            .antMatchers("/", "/user", "/admin", "/users").permitAll()
//            .anyRequest().authenticated()

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter::class.java)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()


    @Bean
    fun authenticationJwtTokenFilter(): AuthTokenFilter = AuthTokenFilter(jwtUtils, userService)


    @Bean
    override fun authenticationManagerBean(): AuthenticationManager = super.authenticationManagerBean()

}