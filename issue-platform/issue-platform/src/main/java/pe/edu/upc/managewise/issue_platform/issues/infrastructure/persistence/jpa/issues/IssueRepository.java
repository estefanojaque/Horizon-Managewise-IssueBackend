package pe.edu.upc.managewise.issue_platform.issues.infrastructure.persistence.jpa.issues;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.managewise.issue_platform.issues.domain.model.aggregates.Issue;

import java.util.Optional;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Long>{
    boolean existsByTitleAndIdIsNot(String title, Long id);
    boolean existsByTitleAndSprintAssociate(String title, int sprintAssociate);
    Optional<Issue> findByTitle(String title);
}

