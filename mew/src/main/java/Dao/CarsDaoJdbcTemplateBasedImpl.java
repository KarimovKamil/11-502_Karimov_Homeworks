package Dao;

import Dao.Models.Car;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CarsDaoJdbcTemplateBasedImpl implements CarsDao {
    private String url = "jdbc:postgresql://localhost:5432/dao";
    private DriverManagerDataSource dataSource = new DriverManagerDataSource(url, "postgres", "postgres");
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    public void addCar(Car car) {
        if (car.getCarOwner() != null) {
            jdbcTemplate.execute("INSERT INTO cars_info (mark, numberplate, release_date, car_owner) VALUES ( '"
                    + car.getMark() + "', '"
                    + car.getNumberplate() + "', '"
                    + car.getReleaseDate() + "', '"
                    + car.getCarOwner() + "' )");
        } else {
            jdbcTemplate.execute("INSERT INTO cars_info (mark, release_date) VALUES ( '"
                    + car.getMark() + "', '"
                    + car.getReleaseDate() + "')");
        }
    }

    public void updateCarOwner(int id, String owner) {
        jdbcTemplate.execute("UPDATE cars_info SET car_owner = '" + owner + "' WHERE auto_id = " + id +";");
    }

    public void updateCarNumberplate(int id, String numberplate) {
        jdbcTemplate.execute("UPDATE cars_info SET numberplate = '" + numberplate + "' WHERE auto_id = " + id +";");
    }

    public void deleteCar(int id) {
        jdbcTemplate.execute("DELETE FROM cars_info WHERE auto_id = " + id + ";");
    }
}
