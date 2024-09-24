package com.example.lab4server.database.services;

import com.example.lab4server.database.domain.Point;
import com.example.lab4server.database.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {
    private PointRepository pointRepository;
    @Autowired
    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public List<Point> getPointsByEmail(String email){
        return pointRepository.getPointsByEmail(email);
    }

    public void deleteAllByEmail(String email){
        pointRepository.deleteAllByEmail(email);
    }

    public void save(Point point){
        pointRepository.save(point);
    }
}
