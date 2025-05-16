package pe.edu.upc.managewise.backend.core.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pe.edu.upc.managewise.backend.meeting.domain.services.MeetingQueryService;
import pe.edu.upc.managewise.backend.meeting.domain.services.RecordingCommandService;
import pe.edu.upc.managewise.backend.meeting.domain.services.RecordingService;
import pe.edu.upc.managewise.backend.meeting.interfaces.rest.RecordingController;
import pe.edu.upc.managewise.backend.meeting.interfaces.rest.transform.RecordingTransformer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecordingController.class)
@AutoConfigureMockMvc(addFilters = false)
public class RecordingControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecordingService recordingService;

    @MockBean
    private RecordingCommandService recordingCommandService;

    @MockBean
    private RecordingTransformer recordingTransformer;

    @MockBean
    private MeetingQueryService meetingQueryService;

    @Test
    void testGetAllRecordings_shouldReturnOk() throws Exception {
        mockMvc.perform(get("/api/recordings"))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteRecording_shouldReturnNoContent() throws Exception {
        mockMvc.perform(delete("/api/recordings/1"))
                .andExpect(status().isNoContent());
    }
}
