package com.poc.feignclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class FeignClientApplication

fun main(args: Array<String>) {
	runApplication<FeignClientApplication>(*args)
}
