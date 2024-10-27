package pe.edu.upc.managewise.issue_platform.reports.interfaces.rest.resources;
//This is the input JSON
public record CreateReportResource(String title, int sprintAssociate , String description, String status, String priority, String assignedTo, String madeBy, String createdIn, String resolutionDate) {
}
