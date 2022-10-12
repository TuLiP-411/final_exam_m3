package com.codegym.module3_final_exam.controller;

import com.codegym.module3_final_exam.dao.StudentDAO;
import com.codegym.module3_final_exam.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteStudent(request, response);
                    break;
                default:
                    listStudent(request, response);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) {
        List<Student> listStudent = studentDAO.selectAllStudent();
        request.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            studentDAO.deleteStudent(id);
            List<Student> listStudent = studentDAO.selectAllStudent();
            request.setAttribute("listStudent", listStudent);
            RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingStudent = studentDAO.selectStudent(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
        request.setAttribute("student", existingStudent);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertStudent(request, response);
                    break;
                case "edit":
                    updateStudent(request, response);
                    break;
                case "search":
                    viewStudent(request, response);
                    break;
                default:


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void viewStudent(HttpServletRequest request, HttpServletResponse response) {
        String searchName = request.getParameter("searchByName");
        List<Student> listStudent = studentDAO.findByName(searchName);
        RequestDispatcher dispatcher;
        if (listStudent == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("listStudent", listStudent);
            request.setAttribute("message", "Reload all students");
            dispatcher = request.getRequestDispatcher("student/list.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void updateStudent(HttpServletRequest request, HttpServletResponse response) {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            LocalDate dob = LocalDate.parse(request.getParameter("dob"));
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            int class_id = Integer.parseInt(request.getParameter("class_id"));

            Student student = new Student(id, name, dob, address, phone, email, class_id);
            studentDAO.updateStudent(student);
            RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
            request.setAttribute("message", "Student has been edited successfully!");
            dispatcher.forward(request, response);

        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int class_id = Integer.parseInt(request.getParameter("class_id"));

        Student student = new Student(name, dob, address, phone, email, class_id);
        try {
            studentDAO.insertStudent(student);
            RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
            request.setAttribute("message", "Student has been inserted successfully!");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
