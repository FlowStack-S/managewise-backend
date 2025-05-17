package pe.edu.upc.managewise.backend.backlog.domain.model.commands;

import pe.edu.upc.managewise.backend.backlog.domain.model.valueobjects.SprintStatus;

import java.util.Date;

public record UpdateSprintCommand(Long id, String title, String goal, SprintStatus status, Date startDate, Date endDate) {
}
