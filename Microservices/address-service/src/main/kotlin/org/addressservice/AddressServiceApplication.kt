package org.addressservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class AddressServiceApplication

fun main(args: Array<String>) {
	runApplication<AddressServiceApplication>(*args)
}
