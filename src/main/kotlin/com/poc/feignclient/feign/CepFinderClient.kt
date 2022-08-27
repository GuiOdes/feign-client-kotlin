package com.poc.feignclient.feign

import com.poc.feignclient.model.ViaCepResponseModel
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    value = "cepFinder",
    url = "https://viacep.com.br/ws"
)
interface CepFinderClient {

    @GetMapping("/{cepNumber}/json/")
    fun findByCepNumber(@PathVariable cepNumber: String): ViaCepResponseModel
}
