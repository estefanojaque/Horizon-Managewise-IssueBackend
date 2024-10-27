package pe.edu.upc.managewise.issue_platform.reports.application.internal.queryservices;
import org.springframework.stereotype.Service;
import pe.edu.upc.managewise.issue_platform.reports.domain.model.aggregates.Report;
import pe.edu.upc.managewise.issue_platform.reports.domain.model.queries.GetAllReportsQuery;
import pe.edu.upc.managewise.issue_platform.reports.domain.model.queries.GetReportByIdQuery;
import pe.edu.upc.managewise.issue_platform.reports.domain.model.queries.GetReportByTitleQuery;
import pe.edu.upc.managewise.issue_platform.reports.domain.services.ReportQueryService;
import pe.edu.upc.managewise.issue_platform.reports.infrastructure.persistence.jpa.repositories.ReportRepository;

import java.util.List;
import java.util.Optional;
@Service
public class ReportQueryServiceImpl implements ReportQueryService{

    private final ReportRepository  reportRepository;

    public ReportQueryServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<Report> handle(GetAllReportsQuery query) {
        return this.reportRepository.findAll();
    }

    @Override
    public Optional<Report> handle(GetReportByIdQuery query) {
        return this.reportRepository.findById(query.reportId());
    }

    @Override
    public Optional<Report> handle(GetReportByTitleQuery query) {
        return this.reportRepository.finByTitle(query.Title());
    }
}
