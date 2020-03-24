package com.example.demo.repository;

import com.example.demo.model.Repertoire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Repertoire, Long> {

}
