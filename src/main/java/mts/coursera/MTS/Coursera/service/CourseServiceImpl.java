package mts.coursera.MTS.Coursera.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mts.coursera.MTS.Coursera.domain.Course;
import mts.coursera.MTS.Coursera.domain.Module;
import mts.coursera.MTS.Coursera.domain.User;
import mts.coursera.MTS.Coursera.dto.CourseDto;
import mts.coursera.MTS.Coursera.repository.CourseRepositoryDB;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 08.02.2024
 */
@Service
@AllArgsConstructor
@Slf4j
public class CourseServiceImpl {
    private final CourseRepositoryDB repository;

    @Transactional
    public Course save(Course course) {
        return repository.save(course);
    }

    public List<CourseDto> findAll() {
        Iterable<Course> courses = repository.findAll();
        List<CourseDto> coursesDto = StreamSupport.stream(courses.spliterator(), false)
                .map(c -> new CourseDto(c.getId(),
                        c.getTitle(),
                        c.getDescription(),
                        gerUsersId(c.getUsers()),
                        c.getCreate(),
                        c.getChange(),
                        c.getRemove(),
                        c.getRating(),
                        getModulesId(c.getModules()),
                        c.getTag()))
                .toList();
        return coursesDto;
    }

    public Optional<Course> findById(Long id) {
        return repository.findById(id);
    }

    public List<Course> findByTitleWithPrefix(String prefix) {
        return repository.findByTitleLike(prefix + "%");
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Set<Long> gerUsersId(Set<User> users) {
        return users.stream()
                .map(User::getId)
                .collect(Collectors.toSet());
    }

    private List<Long> getModulesId(List<Module> modules) {
        return modules.stream()
                .map(Module::getId)
                .toList();
    }
}
