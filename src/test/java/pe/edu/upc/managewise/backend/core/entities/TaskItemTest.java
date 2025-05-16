package pe.edu.upc.managewise.backend.core.entities;

import org.junit.jupiter.api.Test;
import pe.edu.upc.managewise.backend.backlog.domain.model.aggregates.UserStory;
import pe.edu.upc.managewise.backend.backlog.domain.model.entities.TaskItem;
import pe.edu.upc.managewise.backend.backlog.domain.model.valueobjects.Status;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class TaskItemTest {
    @Test
    void testConstructorInitializesFieldsCorrectly() {
        UserStory userStory = new UserStory();
        TaskItem task = new TaskItem(userStory, "Implement Login", "Add auth logic", 5);

        assertThat(task.getTitle()).isEqualTo("Implement Login");
        assertThat(task.getDescription()).isEqualTo("Add auth logic");
        assertThat(task.getStatus()).isEqualTo(Status.TO_DO);
        assertThat(task.getEstimation()).isEqualTo(5);
        assertThat(task.getUserStory()).isEqualTo(userStory);
    }

    @Test
    void testUpdateInformationUpdatesFieldsCorrectly() {
        TaskItem task = new TaskItem();
        task.UpdateInformation("Update UI", "Improve design", Status.DONE, 3);

        assertThat(task.getTitle()).isEqualTo("Update UI");
        assertThat(task.getDescription()).isEqualTo("Improve design");
        assertThat(task.getStatus()).isEqualTo(Status.DONE);
        assertThat(task.getEstimation()).isEqualTo(3);
    }
}
