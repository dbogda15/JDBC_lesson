package DAO.impl;

import DAO.CityDAO;
import model.City;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements CityDAO {
    private final Connection connection;

    public CityDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(City city) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO city (city_name) VALUES ((?))")) {
            statement.setString(1,city.getCity_name());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM city WHERE city_id = (?)")) {
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<City> getAllCity() {
        List<City> list = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM city")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("city_id");
                String city_name = resultSet.getString("city_name");

                list.add(new City(id, city_name));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
