package com.example.zazazan.logger.application.service.impl

import com.example.zazazan.logger.application.service.LoggingService
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.Instant

@Service
class LoggingServiceImpl: LoggingService {

    private val logger: Logger = LoggerFactory.getLogger("filebeat")

    override fun write() {
        val data = HashMap<String, Any>()
        data["action"] = listOf("create", "read", "update", "delete", "something else").random()
        data["timestamp"] = getTimeInNano()

        logger.info(jacksonObjectMapper().writeValueAsString(data))
    }

    private fun getTimeInNano(): BigDecimal {
        val now = Instant.now()

        return BigDecimal.valueOf(String.format("%.4f", now.epochSecond + now.nano * 1E-9).toDouble())
    }
}
