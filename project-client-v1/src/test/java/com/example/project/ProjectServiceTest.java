package com.example.project;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static java.time.Month.NOVEMBER;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;

    @Test
    public void getProject() {
        assertThat(projectService.getProject("test"))
                .isEqualToComparingFieldByField(new Project("test", LocalDate.of(2017, NOVEMBER, 27), LocalDate.of(2018, NOVEMBER, 27)));
    }
}
