package com.poc.feignclient.controller

import com.poc.feignclient.service.ViaCepService
import feign.codec.DecodeException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cep")
class ViaCepController(
    val viaCepService: ViaCepService
) {

    @GetMapping("/{cep}")
    fun findCep(@PathVariable cep: String): ResponseEntity<Any?> {
        return try {
            ResponseEntity(viaCepService.findByCepNumber(cep), HttpStatus.OK)
        } catch (e: Exception) {
            when (e) {
                is DecodeException -> ResponseEntity("A requisição falhou", HttpStatus.BAD_GATEWAY)
                else -> ResponseEntity("Erro inpesperado", HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }
    }
}
