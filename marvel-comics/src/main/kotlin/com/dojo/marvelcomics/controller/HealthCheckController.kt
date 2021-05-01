package com.dojo.marvelcomics.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {

    @GetMapping("/isAlive")
    fun getHealthCheck(): String = "Im alive and don't forget: With great power comes great responsibility."

}