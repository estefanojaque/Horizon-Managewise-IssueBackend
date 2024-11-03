package pe.edu.upc.managewise.issue_platform.issues.domain.model.commands;

public record CreateIssueCommand(String title, int sprintAssociate , String description, String status, String priority, String assignedTo, String madeBy, String createdIn, String resolutionDate) {
}
