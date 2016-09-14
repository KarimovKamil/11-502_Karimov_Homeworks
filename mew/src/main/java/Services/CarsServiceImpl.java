package Services;

import Dao.CarsDao;
import Dao.Models.Car;
import Dao.OldJdbcVersion;

public class CarsServiceImpl implements CarsService {

    private CarsDao carsDao = new OldJdbcVersion();

    public void addCar(Car car) {
        carsDao.addCar(car);
    }

    public void buyCar(int id, String newOwner) {
        carsDao.updateCarOwner(id, newOwner);
    }

    public void deleteCar(int id) {
        carsDao.deleteCar(id);
    }

    public void changeNumberplate(int id, String numberplate) {
        carsDao.updateCarNumberplate(id, numberplate);
    }
}
