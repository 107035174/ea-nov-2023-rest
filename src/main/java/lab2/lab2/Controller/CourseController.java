package lab2.lab2.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lab2.lab2.Model.Course;
import lab2.lab2.Service.CourseService;

@Api(tags = "Course management")
@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @ApiOperation(value = "Create a new Student", response = Course.class)
    @PostMapping("/add")
    public Course save(@RequestBody Course course) {
        return courseService.save(course);
    }

    @ApiOperation(value = "Get the Course by course ID. Returns Optional<Course>", response = Course.class)
    @GetMapping("/{id}")
    public Optional<Course> findById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @ApiOperation(value = "Get all Courses. Returns List<Course>", response = Course.class)
    @GetMapping("/")
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @ApiOperation(value = "Edit Course information", response = Course.class)
    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        return courseService.update(id, course);
    }


    @ApiOperation(value = "Delete the Course by ID", response = Course.class)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        courseService.deleteById(id);
    }

    @ApiOperation(value = "Get Courses by student ID. Returns List<Course>", response = Course.class)
    @GetMapping("/student/{studentId}")
    public List<Course> getCoursesByStudentId(@PathVariable Long studentId) {
        return courseService.getCoursesByStudentId(studentId);
    }
}