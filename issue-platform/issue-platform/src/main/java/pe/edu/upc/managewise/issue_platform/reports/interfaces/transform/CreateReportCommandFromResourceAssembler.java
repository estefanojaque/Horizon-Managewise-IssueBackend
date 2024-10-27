package pe.edu.upc.managewise.issue_platform.reports.interfaces.transform;

import pe.edu.upc.managewise.issue_platform.reports.domain.model.commands.CreateReportCommand;
import pe.edu.upc.managewise.issue_platform.reports.interfaces.rest.resources.CreateReportResource;
//Diferentes maneras de verlo:
//Esta creando un command a partir de un resource ,
//por lo que este resource es de entrada

//Entra un resource y lo convierte en command
//el command es de uso interno por lo que esto es un input(de entrada)

//Entra un JSON y lo convierto en un comman --> input
//Input
public class CreateReportCommandFromResourceAssembler {
    public static CreateReportCommand toCommandFromResource(CreateReportResource resource) {
        return new CreateReportCommand(resource.title(),resource.sprintAssociate() , resource.description(), resource.status(), resource.priority(), resource.assignedTo(), resource.madeBy(), resource.createdIn(), resource.resolutionDate());
    }
}
