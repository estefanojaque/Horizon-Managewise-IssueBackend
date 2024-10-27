package pe.edu.upc.managewise.issue_platform.reports.application.internal.commandservices;
import org.springframework.stereotype.Service;
import pe.edu.upc.managewise.issue_platform.reports.domain.model.aggregates.Report;
import pe.edu.upc.managewise.issue_platform.reports.domain.model.commands.CreateReportCommand;
import pe.edu.upc.managewise.issue_platform.reports.domain.model.commands.DeleteReportCommand;
import pe.edu.upc.managewise.issue_platform.reports.domain.model.commands.UpdateReportCommand;
import pe.edu.upc.managewise.issue_platform.reports.domain.services.ReportCommandService;
import pe.edu.upc.managewise.issue_platform.reports.infrastructure.persistence.jpa.repositories.ReportRepository;


import java.util.Optional;

@Service
public class ReportCommandServiceImpl implements ReportCommandService{
    //Dependency Injection
    private final ReportRepository reportRepository;
    public ReportCommandServiceImpl(ReportRepository reportRepository){
        this.reportRepository = reportRepository;
    }

    //CreateReportCommand
    @Override
    public Long handle(CreateReportCommand command) {
        //Constrains
        //Condition so that there is no same Issue title in the same Sprint
        var title = command.title();
        var sprintAssociate = command.sprintAssociate();
        if (this.reportRepository.existsByTittleAndSprintIsNot(title,sprintAssociate)) {
            throw new IllegalArgumentException("Report with title " + title + "on Sprint "+ sprintAssociate + " already exists");
        }
        //Save and Try-catch
        var profile = new Report(command);
        try {
            this.reportRepository.save(profile);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving report: " + e.getMessage());
        }
        return profile.getId();
    }

    //UpdateReportCommand
    @Override
    public Optional<Report> handle(UpdateReportCommand command) {
        //Constrains
        var reportId = command.reportId();
        var title = command.title();

        if (this.reportRepository.existsByTittleAndIdIsNot(title, reportId)) {
            throw new IllegalArgumentException("Report with title " + title + " already exists");
        }

        // If the report does not exist, throw an exception
        if (!this.reportRepository.existsById(reportId)) {
            throw new IllegalArgumentException("Report with id " + reportId + " does not exist");
        }

        //update report from Command
        var reportToUpdate = this.reportRepository.findById(reportId).get();
        reportToUpdate.updateInformation(command.title(),command.sprintAssociate() , command.description(), command.status(), command.priority(), command.assignedTo(), command.madeBy(), command.createdIn(), command.resolutionDate());

        try {
            var updatedProfile = this.reportRepository.save(reportToUpdate);
            return Optional.of(updatedProfile);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating report: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteReportCommand command) {
        // If the profile does not exist, throw an exception
        //condition if the id value exists or not to delete it
        if (!this.reportRepository.existsById(command.reportId())) {
            throw new IllegalArgumentException("Report with id " + command.reportId() + " does not exist");
        }
        //Save and Try-catch
        // Try to delete the profile, if an error occurs, throw an exception
        try {
            this.reportRepository.deleteById(command.reportId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting report: " + e.getMessage());
        }
    }
}
