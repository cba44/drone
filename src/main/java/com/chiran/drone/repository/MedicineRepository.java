package com.chiran.drone.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chiran.drone.entities.Medicine;

@Repository
public interface MedicineRepository extends CrudRepository<Medicine, Long> {

}
