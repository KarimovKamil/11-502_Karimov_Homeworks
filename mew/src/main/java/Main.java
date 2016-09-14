import Dao.Models.Car;
import Services.CarsService;
import Services.CarsServiceImpl;

public class Main {
    public static void main(String[] args) {
        CarsService carsService = new CarsServiceImpl();
        carsService.addCar(new Car("sdasda", "21.09.1992"));
    }
}
