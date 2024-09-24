package com.example.lab4server.controllers;

import com.example.lab4server.checkers.HitChecker;
import com.example.lab4server.database.domain.Point;
import com.example.lab4server.database.services.PointService;
import com.example.lab4server.dto.PointDTO;
import com.example.lab4server.validators.Converter;
import com.example.lab4server.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class PointController {
    private final PointService pointService;
    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    private Validator validator = new Validator();
    private Converter converter = new Converter();
    private HitChecker hitChecker = new HitChecker();
    private SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss");
    @PostMapping("/point")
    public Point savePoint(@RequestBody PointDTO pointDTO){
        long start_time = System.currentTimeMillis();
        Point point = new Point();
        if(validator.isFloat(pointDTO.getX(), pointDTO.getY(), pointDTO.getR())){
            point.setX(converter.convertObjectToFloat(pointDTO.getX()));
            point.setY(converter.convertObjectToFloat(pointDTO.getY()));
            point.setR(converter.convertObjectToFloat(pointDTO.getR()));
        }
        else throw new NumberFormatException();
        point.setHit(hitChecker.isHit(point.getX(), point.getY(), point.getR()));
        point.setCurrTime(formatter.format(new Date(System.currentTimeMillis())));
        point.setWorkTime(System.currentTimeMillis() - start_time);
        point.setEmail(pointDTO.getEmail());
        pointService.save(point);
        return point;
    }

    @PostMapping("/get")
    public List<Point> sendPoints(@RequestBody String email){
        List<Point> points = pointService.getPointsByEmail(email);
        return points;
    }

    @PostMapping("/delete")
    public void clearPoints(@RequestBody String email){
        pointService.deleteAllByEmail(email);
    }
}
