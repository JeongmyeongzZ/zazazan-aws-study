package com.example.zazazan.logger.presentation.ui.api

import com.example.zazazan.logger.application.service.LoggingService
import org.junit.jupiter.api.Test
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(controllers = [LoggingController::class])
@AutoConfigureMockMvc
class LoggingControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var loggingService: LoggingService

    @Test
    fun writeLog() {
        mockMvc.perform(
            MockMvcRequestBuilders.multipart("/api/logs")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())

        verify(loggingService, times(1)).write()
    }
}
