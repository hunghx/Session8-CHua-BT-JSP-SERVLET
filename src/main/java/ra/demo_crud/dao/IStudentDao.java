package ra.demo_crud.dao;

import ra.demo_crud.model.entity.Student;

import java.util.List;

public interface IStudentDao {
    List<Student> findAll();

    Student findById(Long id);

    void save(Student student);

    void deleteById(Long id);
}
