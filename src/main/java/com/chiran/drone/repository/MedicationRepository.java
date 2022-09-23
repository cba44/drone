package com.chiran.drone.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chiran.drone.entities.Medication;

@Repository
public interface MedicationRepository extends CrudRepository<Medication, Long> {

}
