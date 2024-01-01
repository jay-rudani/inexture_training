package org.userservice.dto

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "user_table")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @Column(nullable = false)
    var firstName: String,
    @Column(nullable = false)
    var lastName: String,
    @Column(nullable = false, unique = true)
    var email: String,
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    var birthDate: Date,
//    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
//    @JsonManagedReference
//    val addresses: MutableList<Address> = mutableListOf()
)


