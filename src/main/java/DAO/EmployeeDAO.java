package DAO;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void create(Employee employee);
    Employee getEmployeeById(int id);
    List <Employee> getAllEmployee ();
    void updateEmployeeById(int id, Employee employee);
    void deleteEmployeeById(int id);
}
