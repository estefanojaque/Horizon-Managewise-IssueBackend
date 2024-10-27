package pe.edu.upc.managewise.issue_platform.reports.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.managewise.issue_platform.reports.domain.model.aggregates.Report;

import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long>{
    boolean existsByTittleAndIdIsNot(String title, Long id);
    boolean existsByTittleAndSprintIsNot(String title,int sprintAssociate);
    Optional<Report> finByTitle(String title);
}

