package pe.edu.upc.managewise.backend.core.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SprintsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateSprintReturns201() throws Exception {
        String requestBody = """
            {
                "title": "Sprint 1",
                "goal": "Primera entrega",
                "startDate": "2025-01-01",
                "endDate": "2025-01-15"
            }
        """;

        mockMvc.perform(post("/api/v1/sprints")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Sprint 1"));
    }

    @Test
    public void testGetAllSprintsReturns200() throws Exception {
        mockMvc.perform(get("/api/v1/sprints"))
                .andExpect(status().isOk());
    }
}