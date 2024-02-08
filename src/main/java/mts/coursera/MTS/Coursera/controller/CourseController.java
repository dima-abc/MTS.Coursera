package mts.coursera.MTS.Coursera.controller;

import lombok.AllArgsConstructor;
import mts.coursera.MTS.Coursera.domain.Course;
import mts.coursera.MTS.Coursera.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 08.02.2024
 */
@RestController
@RequestMapping("/course")
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("")
    public List<Course> courseTable() {
        return courseService.findAll();
    }
}
