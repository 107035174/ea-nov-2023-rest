package lab2.lab2.Service;

import java.util.List;
import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab2.lab2.Model.Course;
import lab2.lab2.Repository.CourseRepo;

@Service
public class CourseService {
    private final CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public Course save(Course course) {
        return courseRepo.save(course);
    }

    public Optional<Course> findById(Long id) {
        return courseRepo.findById(id);
    }

    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    public Course update(Long id, Course course) {
        return courseRepo.update(id, course);
    }

    public void deleteById(Long id) {
        courseRepo.deleteById(id);
    }

    public List<Course> getCoursesByStudentId(Long studentId) {
        return courseRepo.getCoursesByStudentId(studentId);
    }
}
