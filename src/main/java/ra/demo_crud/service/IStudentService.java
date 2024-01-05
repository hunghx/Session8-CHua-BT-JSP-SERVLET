package ra.demo_crud.service;

import ra.demo_crud.model.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    Student findById(Long id);

    void save(Student student);

    void deleteById(Long id);
}
