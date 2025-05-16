package pe.edu.upc.managewise.backend.core.entities;

import org.junit.jupiter.api.Test;
import pe.edu.upc.managewise.backend.meeting.domain.model.aggregates.Meeting;
import pe.edu.upc.managewise.backend.meeting.domain.model.entities.Recording;

import static org.assertj.core.api.Assertions.assertThat;


public class RecordingTest {
    @Test
    void testConstructorInitializesFieldsCorrectly() {
        Meeting meeting = new Meeting();
        Recording recording = new Recording(meeting, "http://link.com", "45min", true);

        assertThat(recording.getMeeting()).isEqualTo(meeting);
        assertThat(recording.getRecordingLink()).isEqualTo("http://link.com");
        assertThat(recording.getDuration()).isEqualTo("45min");
        assertThat(recording.isPublicAccess()).isTrue();
    }

    @Test
    void testUpdateRecordingChangesFields() {
        Recording recording = new Recording();
        recording.updateRecording("http://newlink.com", "60min", false);

        assertThat(recording.getRecordingLink()).isEqualTo("http://newlink.com");
        assertThat(recording.getDuration()).isEqualTo("60min");
        assertThat(recording.isPublicAccess()).isFalse();
    }
}
