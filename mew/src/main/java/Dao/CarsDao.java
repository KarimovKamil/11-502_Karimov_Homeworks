package Dao;

import Dao.Models.Car;

public interface CarsDao {

    public void addCar (Car car);

    public void updateCarOwner(int id, String owner);

    public void updateCarNumberplate(int id, String numberplate);

    public void deleteCar(int id);
}
