package Controllers;
import Dao.Models.Car;
import Services.CarsService;
import Services.CarsServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@org.springframework.stereotype.Controller
public class Controller {

    private CarsService carsService = new CarsServiceImpl();

    @RequestMapping(value = "/add")
    public String add (@RequestParam("mark") String mark, @RequestParam("releaseDate") String releaseDate) throws SQLException {
        Car car = new Car(mark, releaseDate);
        carsService.addCar(car);
        return "success";
    }

    @RequestMapping(value = "/delete")
    public String delete (@RequestParam("id") int id) throws SQLException {
        carsService.deleteCar(id);
        return "success";
    }

    @RequestMapping(value = "/buy")
    public String buy (@RequestParam("id") int id, @RequestParam("owner") String owner) throws SQLException {
        carsService.buyCar(id, owner);
        return "success";
    }

    @RequestMapping(value = "/changenumber")
    public String changeNumberplate (@RequestParam("id") int id, @RequestParam("numberplate") String numberplate) throws SQLException {
        carsService.changeNumberplate(id, numberplate);
        return "success";
    }
}
