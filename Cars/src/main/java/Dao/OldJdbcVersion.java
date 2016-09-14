package Dao;

import Dao.Models.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class OldJdbcVersion implements CarsDao {
    public OldJdbcVersion() {
    }

    public Statement connectToDB () throws SQLException {
        Connecting connect = new Connecting();
        Connection connection = connect.connectionOpening();
        Statement statement = connection.createStatement();
        return statement;
    }

    public void addCar(Car car) {
        try {
            Statement statement = connectToDB();
            if (car.getCarOwner() != null) {
                statement.execute("INSERT INTO cars_info (mark, numberplate, release_date, car_owner) VALUES ( '"
                        + car.getMark() + "', '"
                        + car.getNumberplate() + "', '"
                        + car.getReleaseDate() + "', '"
                        + car.getCarOwner() + "' )");
            } else {
                statement.execute("INSERT INTO cars_info (mark, release_date) VALUES ( '"
                        + car.getMark() + "', '"
                        + car.getReleaseDate() + "')");
            }
        } catch (SQLException e) {

        }

    }

    public void updateCarOwner(int id, String owner) {
        try {
            Statement statement = connectToDB();
            statement.execute("UPDATE cars_info SET car_owner = '" + owner + "' WHERE auto_id = " + id +";");
        } catch (SQLException e) {

        }
    }

    public void updateCarNumberplate(int id, String numberplate) {
        try {
            Statement statement = connectToDB();
            statement.execute("UPDATE cars_info SET numberplate = '" + numberplate + "' WHERE auto_id = " + id +";");
        } catch (SQLException e) {

        }

    }

    public void deleteCar(int id) {
        try {
            Statement statement = connectToDB();
            statement.execute("DELETE FROM cars_info WHERE auto_id = " + id + ";");
        } catch (SQLException e) {

        }
    }

    public Car getCarInfo(int id) {
        Car car = null;
        try {
            Statement statement = connectToDB();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cars_info WHERE auto_id = " + id + ";");

            if (resultSet.next()) {
                car = new Car(resultSet.getInt("auto_id"),
                        resultSet.getString("mark"),
                        resultSet.getString("numberplate"),
                        resultSet.getString("release_date"),
                        resultSet.getString("car_owner"));
            }
        } catch (SQLException e) {

        }

        return car;
    }

    public List<Car> getTable() {
        List<Car> cars = new LinkedList<Car>();
        try {
            Statement statement = connectToDB();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cars_info;");

            while (resultSet.next()) {
                cars.add(new Car(resultSet.getInt("auto_id"),
                        resultSet.getString("mark"),
                        resultSet.getString("numberplate"),
                        resultSet.getString("release_date"),
                        resultSet.getString("car_owner")));
            }
        } catch (SQLException e) {

        }

        return cars;
    }
}
