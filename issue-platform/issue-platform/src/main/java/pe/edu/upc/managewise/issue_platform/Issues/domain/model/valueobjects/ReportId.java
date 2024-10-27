package pe.edu.upc.managewise.issue_platform.Issues.domain.model.valueobjects;

public record ReportId(Long reportId) {
    public ReportId{
        if(reportId<0){
            throw new IllegalArgumentException("Report reportId cannot be negative");
        }
    }
    public ReportId(){
        this(0L);
    }
}
