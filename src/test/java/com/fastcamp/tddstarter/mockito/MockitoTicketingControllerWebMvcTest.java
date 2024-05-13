package com.fastcamp.tddstarter.mockito;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fastcamp.tddstarter.mockito.ticketing.controller.TicketController;
import com.fastcamp.tddstarter.mockito.ticketing.service.TicketingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(TicketController.class)
public class MockitoTicketingControllerWebMvcTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    TicketingService ticketingService;

    @DisplayName("WebMvcTest를 이용한 Controller Test")
    @Test
    public void ticketingControllerTest() throws Exception {
        // given
        String contents = "Test";

        mockMvc.perform(get("/ticket"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.content().string(contents));
    }
}
