package pe.edu.upc.managewise.issue_platform.reports.domain.services;
import pe.edu.upc.managewise.issue_platform.reports.domain.model.aggregates.Report;
import pe.edu.upc.managewise.issue_platform.reports.domain.model.queries.GetAllReportsQuery;
import pe.edu.upc.managewise.issue_platform.reports.domain.model.queries.GetReportByIdQuery;
import pe.edu.upc.managewise.issue_platform.reports.domain.model.queries.GetReportByTitleQuery;

import java.util.List;
import java.util.Optional;
public interface ReportQueryService {
    List<Report> handle(GetAllReportsQuery query);
    Optional<Report> handle(GetReportByIdQuery query);
    Optional<Report> handle(GetReportByTitleQuery query);
}
