package pe.edu.upc.managewise.issue_platform.issues.interfaces.rest.transform;

import pe.edu.upc.managewise.issue_platform.issues.domain.model.aggregates.Issue;
import pe.edu.upc.managewise.issue_platform.issues.domain.model.entities.EventRecordItem;
import pe.edu.upc.managewise.issue_platform.issues.interfaces.rest.resources.EventRecordItemResource;
import pe.edu.upc.managewise.issue_platform.issues.interfaces.rest.resources.IssueResource;

import java.util.List;
import java.util.stream.Collectors;

public class IssueResourceFromEntityAssembler {
    public static IssueResource toResourceFromEntity(Issue issue) {
        List<EventRecordItemResource> history = issue.getEventRecord().getEventRecordItems().stream()
                .map(eventRecordItem -> new EventRecordItemResource(
                        eventRecordItem.getCreatedDate(),
                        eventRecordItem.getMadeBy(),
                        eventRecordItem.getEventName(),
                        eventRecordItem.getDescription()))
                .collect(Collectors.toList());

        return new IssueResource(
                issue.getId(),
                issue.getTitle(),
                issue.getSprintAssociate(),
                issue.getDescription(),
                issue.getStatus(),
                issue.getPriority(),
                issue.getAssignedTo(),
                issue.getMadeBy(),
                issue.getCreatedIn(),
                issue.getResolutionDate(),
                history
        );
    }
}