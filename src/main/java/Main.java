import DAO.impl.CityDAOImpl;
import DAO.impl.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        final String username = "postgres";
        final String password = "******";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        Connection conn = DriverManager.getConnection(url, username, password);
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl(conn);
        CityDAOImpl cityDAO = new CityDAOImpl(conn);

        //Получение конкретного объекта Employee по id
        System.out.println(employeeDAO.getEmployeeById(1));

        //Создание(добавление) сущности Employee в таблицу
        employeeDAO.create(new Employee("Semen", "Popov", "male", 39, 4));

        //Изменение конкретного объекта Employee в базе по id
        employeeDAO.updateEmployeeById(8, new Employee("Maria", "Berezina", "female", 33, 6));

        //Удаление конкретного объекта Employee из базы по id
        employeeDAO.deleteEmployeeById(6);


        // Получение списка всех объектов Employee из базы
        List<Employee> employeeList = new ArrayList<>(employeeDAO.getAllEmployee());

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        //Почему бы не получить список всех объектоа City из базы
        List<City> cityList = new ArrayList<>(cityDAO.getAllCity());

        for (City city : cityList) {
            System.out.println(city);
        }

    }
}
