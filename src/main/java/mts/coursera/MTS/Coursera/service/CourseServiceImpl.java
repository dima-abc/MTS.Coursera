package mts.coursera.MTS.Coursera.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mts.coursera.MTS.Coursera.domain.Course;
import mts.coursera.MTS.Coursera.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 08.02.2024
 */
@Service
@AllArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService{
    private final CourseRepository repository;

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }
}
