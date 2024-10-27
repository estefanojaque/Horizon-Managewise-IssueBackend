package pe.edu.upc.managewise.issue_platform.reports.domain.model.commands;

public record CreateReportCommand(String title, int sprintAssociate , String description, String status, String priority, String assignedTo, String madeBy, String createdIn, String resolutionDate) {
}
