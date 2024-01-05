package ra.demo_crud.controller;

import ra.demo_crud.model.entity.Student;
import ra.demo_crud.service.IStudentService;
import ra.demo_crud.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet",value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    private static final IStudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action  = req.getParameter("action");
        if(action!=null){
            switch (action){
                case "getAll":
                    showAllStudent(req, resp);
                    break;
                case "DELETE" :
                    // lấy ra id
                    Long id = Long.valueOf(req.getParameter("id"));
                    studentService.deleteById(id);
                    showAllStudent(req, resp);
                    break;
                case "ADD":
                    req.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(req, resp);
                    break;
                case "EDIT":
                    Long idEdit = Long.valueOf(req.getParameter("id"));
                    req.setAttribute("studentEdit",studentService.findById(idEdit));
                    req.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(req, resp);
                    break;
            }
        }

    }

    private static void showAllStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student>  students = studentService.findAll();
        req.setAttribute("students",students);
        req.getRequestDispatcher("/WEB-INF/views/list-student.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // set utf8
        req.setCharacterEncoding("utf-8");

        String action  = req.getParameter("action");
        if(action!=null){
            switch (action){
                case "ADD":
                    String name = req.getParameter("name");
                    Integer age = Integer.valueOf(req.getParameter("age"));
                    Boolean sex = Boolean.valueOf(req.getParameter("sex"));
                    Student newStudent = new Student(null,name,age,sex);
                    studentService.save(newStudent);
                    showAllStudent(req, resp);
                    break;
                case "EDIT":
                    Long  idEdit = Long.valueOf(req.getParameter("id"));
                    String nameEdit = req.getParameter("name");
                    Integer ageEdit = Integer.valueOf(req.getParameter("age"));
                    Boolean sexEdit = Boolean.valueOf(req.getParameter("sex"));
                    Student updateStudent = new Student(idEdit,nameEdit,ageEdit,sexEdit);
                    studentService.save(updateStudent);
                    showAllStudent(req, resp);
                    break;
            }
        }
    }
}
