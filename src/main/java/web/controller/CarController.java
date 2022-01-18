package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {
    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping
    public String cars(@RequestParam(value = "count", required = false, defaultValue = "-1") Integer count, Model model) {
        if (count < 5 && count != -1) {
            model.addAttribute("cars", carService.getCars().subList(0, count));
        } else {
            model.addAttribute("cars", carService.getCars());
        }
        return "cars";
    }
}
