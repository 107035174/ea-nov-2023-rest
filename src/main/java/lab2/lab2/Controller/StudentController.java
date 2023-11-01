package lab2.lab2.Controller;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lab2.lab2.Model.Course;
import lab2.lab2.Model.Student;
import lab2.lab2.Service.StudentService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api(tags = "Student management")
@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    private final StudentService studentService = new StudentService();

    @ApiOperation(value = "Create a new Course", response = Course.class)
    @PostMapping("/add")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @ApiOperation(value = "Get a Student by ID. Returns Optional<Student>", response = Course.class)
    @GetMapping("/{id}")
    public Optional<Student> findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @ApiOperation(value = "Create all Students. Returns List<Student>", response = Course.class)
    @GetMapping("/")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @ApiOperation(value = "Edit Student information", response = Course.class)
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @ApiOperation(value = "Delete a student", response = Course.class)
    @DeleteMapping("/")
    public void delete(@RequestBody Student student) {
        studentService.delete(student);
    }

    @ApiOperation(value = "Delete a student by ID", response = Course.class)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @ApiOperation(value = "Get students by ID. Returns List<Student>", response = Course.class)
    @GetMapping("/major/")
    public List<Student> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentByMajor(major);
    }
}
