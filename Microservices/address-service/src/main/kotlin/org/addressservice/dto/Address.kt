package org.addressservice.dto

import jakarta.persistence.*

@Entity
@Table(name = "address_table")
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @Column(nullable = false)
    var addressLine1: String,
    @Column(nullable = false)
    var addressLine2: String,
    @Column(nullable = false)
    var city: String,
    @Column(nullable = false)
    var state: String,
    @Column(nullable = false)
    var country: String,
    @Column(nullable = false)
    var userEmail: String?
)
