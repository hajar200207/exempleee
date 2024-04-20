package controllers;

import models.Employee;
import services.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeController", urlPatterns = {"/employees", "/employees/add", "/employees/edit", "/employees/delete", "/employees/search", "/employees/filter"})
public class EmployeeController extends HttpServlet {
    private EmployeeService employeeService;

    public void init() {
        employeeService = new EmployeeService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/employees/add":
                showAddForm(request, response);
                break;
            case "/employees/edit":
                showEditForm(request, response);
                break;
            case "/employees/delete":
                deleteEmployee(request, response);
                break;
            case "/employees/search":
                searchEmployees(request, response);
                break;
            case "/employees/filter":
                filterEmployees(request, response);
                break;
            default:
                listEmployees(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/employees/add":
                addEmployee(request, response);
                break;
            case "/employees/edit":
                updateEmployee(request, response);
                break;
            default:
                listEmployees(request, response);
                break;
        }
    }

    private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeService.getAllEmployees();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/WEB-INF/views/employee/employeeList.jsp").forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/employee/addEmployee.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getEmployeeById(id);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("/WEB-INF/views/employee/editEmployee.jsp").forward(request, response);
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String department = request.getParameter("department");
        String position = request.getParameter("position");

        Employee newEmployee = new Employee(name, email, phone, department, position);
        employeeService.addEmployee(newEmployee);

        response.sendRedirect(request.getContextPath() + "/employees");
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String department = request.getParameter("department");
        String position = request.getParameter("position");

        Employee updatedEmployee = new Employee(id, name, email, phone, department, position);
        employeeService.updateEmployee(updatedEmployee);

        response.sendRedirect(request.getContextPath() + "/employees");
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(id);
        response.sendRedirect(request.getContextPath() + "/employees");
    }

    private void searchEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Employee> employees = employeeService.searchEmployees(keyword);
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/WEB-INF/views/employee/searchEmployees.jsp").forward(request, response);
    }

    private void filterEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String department = request.getParameter("department");
        String position = request.getParameter("position");
        List<Employee> employees = employeeService.filterEmployees(department, position);
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/WEB-INF/views/employee/filteredEmployees.jsp").forward(request, response);
    }
}
