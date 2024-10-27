package pe.edu.upc.managewise.issue_platform.Issues.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.edu.upc.managewise.issue_platform.Issues.domain.model.valueobjects.ReportId;
import pe.edu.upc.managewise.issue_platform.Issues.domain.model.valueobjects.IssueCode;
import pe.edu.upc.managewise.issue_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Table(name = "issues")
public class Issue extends AuditableAbstractAggregateRoot<Issue>{

    @Getter
    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name = "issueCode", column = @Column(name = "code", length = 36, nullable = false))
    })
    private final IssueCode issueCode;

    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name = "reportId", column = @Column(name = "report_id", nullable = false))
    })
    private ReportId reportId;

    //--------------------------
    public Issue() {
        this.issueCode = new IssueCode();
    }

    public Issue(Long reportId) {
        this();
        this.reportId = new ReportId(reportId);
    }

    public Long getReportId() {
        return reportId.reportId();
    }
}
