package mts.coursera.MTS.Coursera.controller;

import lombok.AllArgsConstructor;
import mts.coursera.MTS.Coursera.domain.Course;
import mts.coursera.MTS.Coursera.dto.CourseRequestToCreate;
import mts.coursera.MTS.Coursera.dto.CourseRequestToUpdate;
import mts.coursera.MTS.Coursera.service.CourseService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable("id") Long id) {
        return courseService.findById(id).orElseThrow();
    }

    @PostMapping("")
    public Course createCourse(@RequestBody CourseRequestToCreate request) {
        Course course = new Course(0, request.getAuthor(), request.getTitle());
        return courseService.save(course);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable("id") Long id, @RequestBody CourseRequestToUpdate request) {
        Course course = courseService.findById(id).orElseThrow();
        course.setAuthor(request.getAuthor());
        course.setTitle(request.getTitle());
        courseService.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
    }
}
