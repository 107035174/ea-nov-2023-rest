package lab2.lab2.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import lab2.lab2.Model.Student;

@Repository
public class StudentRepo {
    private final List<Student> students = new ArrayList<>();

    public Student save(Student student) {
        if (student.getId() == null) {
            long newId = students.size() + 1;
            student.setId(newId);
        }
        students.add(student);
        return student;
    }

    public Optional<Student> findById(Long id) {
        return students.stream()
                .filter(data -> data.getId() == id)
                .findFirst();
    }

    public List<Student> findAll() {
        return students;
    }

    public Student update(Long id, Student student) {
        Optional<Student> toBeUpdated = findById(id);
        if (toBeUpdated.isPresent()) {
            students.remove(toBeUpdated.get());
            student.setId(id);
            return student;
        } else {
            return null;
        }
    }

    public void delete(Student student) {
        students.remove(student);
    }

    public void deleteById(Long id) {
        students.removeIf(data -> data.getId() == id);
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter(data -> data.getMajor().equals(major))
                .collect(Collectors.toList());
    }
}
