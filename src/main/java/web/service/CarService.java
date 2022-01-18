package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.CarDao;
import web.models.Car;

import java.util.List;

@Component
public class CarService {
    private CarDao carDao;

    @Autowired
    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }

    public List<Car> getCars() {
        return carDao.getCars();
    }
}
