package pe.edu.upc.managewise.backend.core.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pe.edu.upc.managewise.backend.meeting.domain.services.MeetingCommandService;
import pe.edu.upc.managewise.backend.meeting.domain.services.MeetingQueryService;
import pe.edu.upc.managewise.backend.meeting.interfaces.rest.MeetingController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MeetingController.class)
@AutoConfigureMockMvc(addFilters = false)
class MeetingControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MeetingCommandService meetingCommandService;

    @MockBean
    private MeetingQueryService meetingQueryService;

    @Test
    void testGetAllMeetings_shouldReturnOk() throws Exception {
        mockMvc.perform(get("/api/v1/meetings"))
                .andExpect(status().isOk());
    }


    @Test
    void testDeleteMeeting_shouldReturnNoContent() throws Exception {
        mockMvc.perform(delete("/api/v1/meetings/1"))
                .andExpect(status().isNoContent());
    }
}

