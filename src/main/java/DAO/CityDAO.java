package DAO;
import java.util.List;

import model.City;

public interface CityDAO {
    void create(City city);
    void deleteById(int id);
    List<City> getAllCity();
}
