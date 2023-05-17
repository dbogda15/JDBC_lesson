
import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {

        //Задание 1

        final String username = "postgres";
        final String password = "******";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        //ID сотрудника
        int id = 1;

        try (final Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {
            statement.setInt(1,id);

            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String age = " Age: " + resultSet.getInt("age");
                String gender = " Gender: " + resultSet.getString("gender");

                System.out.println(firstName + " " + lastName + gender + age);
            }
        }
    }
}
