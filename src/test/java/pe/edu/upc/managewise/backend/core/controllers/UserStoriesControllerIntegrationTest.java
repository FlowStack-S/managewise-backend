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
public class UserStoriesControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateUserStoryReturns201() throws Exception {
        String requestBody = """
            {
                "title": "Historia de usuario 1",
                "description": "Como usuario quiero..."
            }
        """;

        mockMvc.perform(post("/api/v1/user-stories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Historia de usuario 1"));
    }

    @Test
    public void testGetAllUserStoriesReturns200() throws Exception {
        mockMvc.perform(get("/api/v1/user-stories"))
                .andExpect(status().isOk());
    }
}
