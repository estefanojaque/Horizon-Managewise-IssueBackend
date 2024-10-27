package pe.edu.upc.managewise.issue_platform.Issues.domain.model.valueobjects;
import java.util.UUID;

public record IssueCode(String issueCode) {
    public IssueCode(){
        this(UUID.randomUUID().toString());
    }
    public IssueCode{
        if(issueCode == null || issueCode.isBlank()){
            throw new IllegalArgumentException("Issue code cannot be null or blank");
        }
        if(issueCode.length() != 36){
            throw new IllegalArgumentException("Issue code must be 36 characters long");
        }
        if (!issueCode.matches("[a-f0-9]{8}-([a-f0-9]{4}-){3}[a-f0-9]{12}")) {
            throw new IllegalArgumentException("Issue code must be a valid UUID");
        }
    }
}
