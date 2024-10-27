package pe.edu.upc.managewise.issue_platform.reports.interfaces.transform;

import pe.edu.upc.managewise.issue_platform.reports.domain.model.commands.UpdateReportCommand;
import pe.edu.upc.managewise.issue_platform.reports.interfaces.rest.resources.ReportResource;

//Input
public record UpdateReportCommandFromResourceAssembler() {
    public static UpdateReportCommand toCommandFromResource(Long reportId, ReportResource resource){
        return new UpdateReportCommand(reportId,resource.title(),resource.sprintAssociate() , resource.description(), resource.status(), resource.priority(), resource.assignedTo(), resource.madeBy(), resource.createdIn(), resource.resolutionDate());
    }
}
