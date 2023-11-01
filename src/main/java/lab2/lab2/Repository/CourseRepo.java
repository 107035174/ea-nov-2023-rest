package lab2.lab2.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import lab2.lab2.Model.Course;

@Repository
public class CourseRepo {
    private final List<Course> courses = new ArrayList<>();

    public Course save(Course course) {
        if (course.getId() == null) {
            long newId = courses.size() + 1;
            course.setId(newId);
        }
        courses.add(course);
        return course;
    }

    public Optional<Course> findById(Long id) {
        return courses.stream()
                .filter(data -> data.getId() == id)
                .findFirst();
    }

    public List<Course> findAll() {
        return courses;
    }

    public Course update(Long id, Course course) {
        Optional<Course> toBeUpdated = findById(id);
        if (toBeUpdated.isPresent()) {
            courses.remove(toBeUpdated.get());
            course.setId(id);
            courses.add(course);
            return course;
        } else {
            return null;
        }
    }

    public void delete(Course course) {
        courses.remove(course);
    }

    public void deleteById(Long id) {
        courses.removeIf(data -> data.getId().equals(id));
    }

    public List<Course> getCoursesByStudentId(Long studentId) {
        return courses.stream()
                .filter(data -> data.getStudent().getId() == studentId)
                .collect(Collectors.toList());
    }

}
