package com.chiran.drone.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chiran.drone.entities.Drone;

@Repository
public interface DroneRepository extends CrudRepository<Drone, Long> {

	Drone findBySerial(String serial);

}
