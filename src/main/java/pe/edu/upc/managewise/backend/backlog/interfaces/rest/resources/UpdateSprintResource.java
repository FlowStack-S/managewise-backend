package pe.edu.upc.managewise.backend.backlog.interfaces.rest.resources;

import pe.edu.upc.managewise.backend.backlog.domain.model.valueobjects.SprintStatus;

import java.util.Date;

public record UpdateSprintResource (
        String title,
        String goal,
        SprintStatus status,
        Date startDate,
        Date endDate
) {
}
