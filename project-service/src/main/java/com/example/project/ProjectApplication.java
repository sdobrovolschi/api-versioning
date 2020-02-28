package com.example.project;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.time.Month.NOVEMBER;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
}

@RestController
@RequestMapping("/projects")
class ProjectController {

	@GetMapping("/{code}")
	Project getProject(String code) {
//		return new Project("test", LocalDate.now(), LocalDate.now()); //before adding the new field
		return new Project("test", new DateRange(LocalDate.of(2017, NOVEMBER, 27), LocalDate.of(2018, NOVEMBER, 27))); //compatible with v1 and v2
	}
}

class Project {

	private final String code;
//	private final LocalDate startedOn;
//	private final LocalDate completedOn;
	private final DateRange dateRange; //If we need to make a breaking change, we can do it in a multiple step process:
	// 1. Add the new field and deploy.
	// 2. Update the consumers to use the new field, then deploy.
	// 3. Remove the old fields and deploy.

//	public Project(String code, LocalDate startedOn, LocalDate completedOn) {
//		this.code = code;
//		this.startedOn = startedOn;
//		this.completedOn = completedOn;
//	}

	public Project(String code, DateRange dateRange) {
		this.code = code;
		this.dateRange = dateRange;
	}

	public String getCode() {
		return code;
	}

	@Deprecated //remove once each client migrates to v2
	public LocalDate getStartedOn() {
		return dateRange.getStartedOn();
	}

	@Deprecated //remove once each client migrates to v2
	public LocalDate getCompletedOn() {
		return dateRange.getCompletedOn();
	}

	public DateRange getDateRange() {
		return dateRange;
	}
}

class DateRange {

	private final LocalDate startedOn;
	private final LocalDate completedOn;

	DateRange(LocalDate startedOn, LocalDate completedOn) {
		this.startedOn = startedOn;
		this.completedOn = completedOn;
	}

	public LocalDate getStartedOn() {
		return startedOn;
	}

	public LocalDate getCompletedOn() {
		return completedOn;
	}
}
