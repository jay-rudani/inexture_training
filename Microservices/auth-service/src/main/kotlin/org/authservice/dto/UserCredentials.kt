package org.authservice.dto

import jakarta.persistence.*
import org.authservice.enums.Role
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

@Entity
data class UserCredentials(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,
    @Column(nullable = false, unique = true)
    var email: String,
    @Column(nullable = false)
    var passWord: String,
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var role: Role,
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    var createdAt: Date
) : UserDetails {

    data class Builder(
        var email: String = "",
        var password: String = "",
        var role: Role = Role.USER,
        var createdAt: Date = Date()
    ) {
        fun email(email: String) = apply { this.email = email }
        fun password(password: String) = apply { this.password = password }
        fun role(role: Role) = apply { this.role = role }
        fun createdAt(createdAt: Date) = apply { this.createdAt = createdAt }

        fun build() = UserCredentials(null, email, password, role, createdAt)
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority("ROLE_" + role.name))
    }

    override fun getPassword(): String = passWord

    override fun getUsername(): String = email

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}
