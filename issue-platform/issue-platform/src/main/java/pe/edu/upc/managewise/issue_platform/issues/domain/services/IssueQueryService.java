package pe.edu.upc.managewise.issue_platform.issues.domain.services;
import pe.edu.upc.managewise.issue_platform.issues.domain.model.aggregates.Issue;
import pe.edu.upc.managewise.issue_platform.issues.domain.model.queries.GetAllIssuesQuery;
import pe.edu.upc.managewise.issue_platform.issues.domain.model.queries.GetIssueByIdQuery;
import pe.edu.upc.managewise.issue_platform.issues.domain.model.queries.GetIssueByTitleQuery;

import java.util.List;
import java.util.Optional;
public interface IssueQueryService {
    List<Issue> handle(GetAllIssuesQuery query);
    Optional<Issue> handle(GetIssueByIdQuery query);
    Optional<Issue> handle(GetIssueByTitleQuery query);
}
