package lab2.lab2.Service;

import java.util.List;
import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab2.lab2.Model.Student;
import lab2.lab2.Repository.StudentRepo;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student save(Student student) {
        return studentRepo.save(student);
    }

    public Optional<Student> findById(Long id) {
        return studentRepo.findById(id);
    }

    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    public Student update(Long id, Student student) {
        return studentRepo.update(id, student);
    }

    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }

    public List<Student> getStudentByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }
}
