package ra.demo_crud.service;

import ra.demo_crud.dao.IStudentDao;
import ra.demo_crud.dao.StudentDaoImpl;
import ra.demo_crud.model.Student;

import java.util.List;

public class StudentServiceImpl implements IStudentService{
    private static IStudentDao studentDao = new StudentDaoImpl();
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentDao.findById(id);
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentDao.deleteById(id);
    }
}
