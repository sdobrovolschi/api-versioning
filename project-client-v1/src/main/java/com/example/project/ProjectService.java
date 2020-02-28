package com.example.project;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "projects", url = "localhost:8081")
public interface ProjectService {

    @RequestMapping(method = RequestMethod.GET, value = "/v1/projects/{code}", consumes = MediaType.APPLICATION_JSON_VALUE)
    Project getProject(@PathVariable("code") String code);
}
