package pe.edu.upc.managewise.issue_platform.issues.interfaces.rest.resources;
//This is the input JSON
public record CreateIssueResource(String title, int sprintAssociate , String description, String status, String priority, String assignedTo, String madeBy, String createdIn, String resolutionDate) {
}
