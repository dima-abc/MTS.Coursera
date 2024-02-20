package mts.coursera.MTS.Coursera.controller;

import lombok.AllArgsConstructor;
import mts.coursera.MTS.Coursera.dto.LessonDto;
import mts.coursera.MTS.Coursera.dto.LessonRequestToCreate;
import mts.coursera.MTS.Coursera.dto.LessonRequestToUpdate;
import mts.coursera.MTS.Coursera.service.LessonServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 20.02.2024
 */
@RestController
@RequestMapping("/lessons")
@AllArgsConstructor
public class LessonController {
    private final LessonServiceImpl lessonService;

    @GetMapping("")
    public List<LessonDto> findAllLessonsDto() {
        return lessonService.findAll();
    }

    @GetMapping("/{id}")
    public LessonDto findLessonById(@PathVariable("id") Long id) {
        return lessonService.findById(id).orElseThrow();
    }

    @PostMapping("")
    public LessonDto createLesson(@RequestBody LessonRequestToCreate lessonDto) {
        return lessonService.save(lessonDto);
    }

    @PutMapping("/{id}")
    public void updateLesson(@PathVariable("id") Long id, @RequestBody LessonRequestToUpdate lessonDto) {
        lessonService.update(id, lessonDto);
    }

    @DeleteMapping("{id}")
    public void deleteLesson(@PathVariable("id") Long id) {
        lessonService.deleteById(id);
    }
}
