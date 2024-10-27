package pe.edu.upc.managewise.issue_platform.reports.domain.model.aggregates;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
//import ppe.edu.upc.managewise.issue_platform.reports.domain.model.commands.CreateProfileCommand;
//import pe.edu.upc.managewise.issue_platform.reports.domain.model.valueobjects.StreetAddress;
import pe.edu.upc.managewise.issue_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Table(name = "reports")
public class Report extends AuditableAbstractAggregateRoot<Report> {
    @Getter
    @NotNull
    @NotBlank
    @Column(name = "title", length = 70, nullable = false)
    private String title;

    @Getter
    @Min(0)
    @Max(6)
    @Column(name = "sprint_associate", columnDefinition = "smallint", nullable = false)
    private int sprintAssociate;

    @Getter
    @NotNull
    @NotBlank
    @Column(name = "description", length = 300, nullable = false)
    private String description;

    @Getter
    @NotNull
    @NotBlank
    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @Getter
    @NotNull
    @NotBlank
    @Column(name = "priority", length = 10, nullable = false)
    private String priority;

    @Getter
    @NotNull
    @NotBlank
    @Column(name = "assigned_to", length = 70, nullable = false)
    private String assignedTo;

    @Getter
    @NotNull
    @NotBlank
    @Column(name = "made_by", length = 70, nullable = false)
    private String madeBy;

    @Getter
    @NotNull
    @NotBlank
    @Column(name = "created_in", length = 70, nullable = false)
    private String createdIn;

    @Getter
    @NotNull
    @NotBlank
    @Column(name = "resolution_date", length = 70, nullable = false)
    private String resolutionDate;

    public Report(String title, int sprintAssociate, String description, String status, String priority, String assignedTo, String madeBy, String createdIn, String resolutionDate) {
        this.title = title;
        this.sprintAssociate = sprintAssociate;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.assignedTo = assignedTo;
        this.madeBy = madeBy;
        this.createdIn = createdIn;
        this.resolutionDate = resolutionDate;
    }

    public Report() {
    }
}