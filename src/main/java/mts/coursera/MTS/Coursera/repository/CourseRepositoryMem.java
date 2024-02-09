package mts.coursera.MTS.Coursera.repository;

import mts.coursera.MTS.Coursera.domain.Course;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 08.02.2024
 */
@Repository
@Primary
public class CourseRepositoryMem implements CourseRepository {
    private final AtomicLong keys = new AtomicLong(0);
    private final Map<Long, Course> storage = new ConcurrentHashMap<>();

    public CourseRepositoryMem() {
        Course course1 = new Course(keys.incrementAndGet(), "Петров А.В.", "Основы кройки и шитья");
        Course course2 = new Course(keys.incrementAndGet(), "Мошкина А.В", "Введение в архитектурный дизайн");
        storage.put(course1.getId(), course1);
        storage.put(course2.getId(), course2);
    }

    @Override
    public Course save(Course course) {
        if (course.getId() == 0) {
            course.setId(keys.incrementAndGet());
        }
        return storage.put(course.getId(), course);
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<Course> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public boolean delete(Long id) {
        return storage.remove(id) != null;
    }
}
