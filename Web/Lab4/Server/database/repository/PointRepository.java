package com.example.lab4server.database.repository;

import com.example.lab4server.database.domain.Point;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {
    List<Point> getPointsByEmail(String email);
    @Transactional
    void deleteAllByEmail(String email);
}
