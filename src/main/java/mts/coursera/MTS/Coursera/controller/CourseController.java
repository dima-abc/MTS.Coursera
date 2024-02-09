package mts.coursera.MTS.Coursera.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import mts.coursera.MTS.Coursera.domain.Course;
import mts.coursera.MTS.Coursera.dto.CourseRequestToCreate;
import mts.coursera.MTS.Coursera.dto.CourseRequestToUpdate;
import mts.coursera.MTS.Coursera.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 08.02.2024
 */
@RestController
@RequestMapping("/courses")
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("")
    public List<Course> courseTable() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourse(@Min(value = 1) @PathVariable("id") Long id) {
        return courseService.findById(id).orElseThrow();
    }

    @PostMapping("")
    public Course createCourse(@Valid @RequestBody CourseRequestToCreate request) {
        Course course = new Course(0, request.getAuthor(), request.getTitle());
        return courseService.save(course);
    }

    @PutMapping("/{id}")
    public void updateCourse(@Min(value = 1) @PathVariable("id") Long id, @Valid @RequestBody CourseRequestToUpdate request) {
        Course course = courseService.findById(id).orElseThrow();
        course.setAuthor(request.getAuthor());
        course.setTitle(request.getTitle());
        courseService.save(course);
    }

    @GetMapping("/filter")
    public List<Course> findByTitleWithPrefix(@RequestParam(name = "titlePrefix", required = false) String prefix) {
        String require = Objects.requireNonNull(prefix, "");
        return courseService.findByTitleWithPrefix(require);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@Min(value = 1) @PathVariable Long id) {
        courseService.delete(id);
    }
}
