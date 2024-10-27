package pe.edu.upc.managewise.issue_platform.reports.interfaces.transform;

import pe.edu.upc.managewise.issue_platform.reports.domain.model.aggregates.Report;
import pe.edu.upc.managewise.issue_platform.reports.interfaces.rest.resources.ReportResource;
// esta convirtiendo un entity que es de uso interno a un JSON(resource) hacia el front
// esta haciendo el proceso  de conversion
// es resource de salida
//Output
public class ReportResourceFromEntityAssembler {
    public static ReportResource toResourceFromEntity(Report entity){
        return new ReportResource(entity.getId(), entity.getTitle(),entity.getSprintAssociate() , entity.getDescription(), entity.getStatus(), entity.getPriority(), entity.getAssignedTo(), entity.getMadeBy(), entity.getCreatedIn(), entity.getResolutionDate());
    }
}
