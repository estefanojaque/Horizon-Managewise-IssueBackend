package pe.edu.upc.managewise.issue_platform.issues.domain.services;
import pe.edu.upc.managewise.issue_platform.issues.domain.model.aggregates.Issue;
import pe.edu.upc.managewise.issue_platform.issues.domain.model.commands.CreateIssueCommand;
import pe.edu.upc.managewise.issue_platform.issues.domain.model.commands.DeleteIssueCommand;
import pe.edu.upc.managewise.issue_platform.issues.domain.model.commands.UpdateIssueCommand;

import java.util.Optional;

public interface IssueCommandService {
    Long handle(CreateIssueCommand command);
    Optional<Issue> handle(UpdateIssueCommand command);
    void handle(DeleteIssueCommand command);
}
