package pe.edu.upc.managewise.issue_platform.reports.domain.services;
import pe.edu.upc.managewise.issue_platform.reports.domain.model.aggregates.Report;
import pe.edu.upc.managewise.issue_platform.reports.domain.model.commands.CreateReportCommand;
import pe.edu.upc.managewise.issue_platform.reports.domain.model.commands.DeleteReportCommand;
import pe.edu.upc.managewise.issue_platform.reports.domain.model.commands.UpdateReportCommand;

import java.util.Optional;

public interface ReportCommandService {
    Long handle(CreateReportCommand command);
    Optional<Report> handle(UpdateReportCommand command);
    void handle(DeleteReportCommand command);
}
