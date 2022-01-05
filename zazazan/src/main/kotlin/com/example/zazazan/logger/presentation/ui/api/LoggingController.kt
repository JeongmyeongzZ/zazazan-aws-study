package com.example.zazazan.logger.presentation.ui.api

import com.example.zazazan.logger.application.service.LoggingService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/logs")
class LoggingController(private val service: LoggingService) {

    @PostMapping
    fun write(): ResponseEntity<Void> {
        service.write()

        return ResponseEntity.ok().build()
    }
}
