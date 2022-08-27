package com.poc.feignclient.service

import com.poc.feignclient.feign.CepFinderClient
import com.poc.feignclient.model.ViaCepResponseModel
import org.springframework.stereotype.Service

@Service
class ViaCepService (
    private val cepFinderClient: CepFinderClient
) {

    fun findByCepNumber(cepNumber: String): ViaCepResponseModel {
        return cepFinderClient.findByCepNumber(cepNumber)
    }
}
