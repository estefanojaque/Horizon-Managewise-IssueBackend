package pe.edu.upc.managewise.issue_platform.reports.interfaces.rest.resources;
//This is my output JSON
public record ReportResource(Long id, String title, int sprintAssociate , String description, String status, String priority, String assignedTo, String madeBy, String createdIn, String resolutionDate) {
}
