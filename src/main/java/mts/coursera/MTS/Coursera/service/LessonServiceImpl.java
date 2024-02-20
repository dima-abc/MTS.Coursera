package mts.coursera.MTS.Coursera.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mts.coursera.MTS.Coursera.domain.Lesson;
import mts.coursera.MTS.Coursera.domain.Theme;
import mts.coursera.MTS.Coursera.dto.LessonDto;
import mts.coursera.MTS.Coursera.dto.LessonRequestToCreate;
import mts.coursera.MTS.Coursera.dto.LessonRequestToUpdate;
import mts.coursera.MTS.Coursera.repository.LessonRepositoryDB;
import mts.coursera.MTS.Coursera.repository.ThemeRepositoryDB;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.StreamSupport;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 20.02.2024
 */
@Service
@AllArgsConstructor
@Slf4j
public class LessonServiceImpl {
    private final ThemeRepositoryDB themeRepository;
    private final LessonRepositoryDB lessonRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public LessonDto save(LessonRequestToCreate lessonDto) throws NoSuchElementException {
        Theme theme = themeRepository.findById(lessonDto.getThemeId())
                .orElseThrow(() -> new NoSuchElementException("Theme ID" + lessonDto.getThemeId() + "is not found"));
        Lesson lesson = new Lesson(null, lessonDto.getTitle(), lessonDto.getDescription(), lessonDto.getContent(), theme);
        lessonRepository.save(lesson);
        return new LessonDto(lesson.getId(),
                lesson.getTitle(),
                lesson.getDescription(),
                lesson.getContent(),
                lesson.getTheme().getId());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Long id, LessonRequestToUpdate lessonDto) {
        Lesson lesson = new Lesson(id,
                lessonDto.getTitle(),
                lessonDto.getDescription(),
                lessonDto.getContent(),
                new Theme(lessonDto.getThemeId()));
        lessonRepository.save(lesson);
    }

    @Transactional(readOnly = true)
    public Optional<LessonDto> findById(Long id) throws NoSuchElementException {
        Optional<Lesson> lesson = lessonRepository.findById(id);
        if (lesson.isEmpty()) {
            return Optional.empty();
        }
        LessonDto lessonDto = new LessonDto(lesson.get().getId(),
                lesson.get().getTitle(),
                lesson.get().getDescription(),
                lesson.get().getContent(),
                lesson.get().getTheme().getId());
        return Optional.of(lessonDto);
    }

    @Transactional(readOnly = true)
    public List<LessonDto> findAll() {
        Iterable<Lesson> lesson = lessonRepository.findAll();
        List<LessonDto> lessonsDto = StreamSupport.stream(lesson.spliterator(), false)
                .map(l -> new LessonDto(l.getId(), l.getTitle(), l.getDescription(), l.getContent(), l.getTheme().getId()))
                .toList();
        return lessonsDto;
    }

    public void deleteById(Long id) {
        lessonRepository.deleteById(id);
    }
}
