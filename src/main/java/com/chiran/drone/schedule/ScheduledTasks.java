package com.chiran.drone.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.chiran.drone.entities.Drone;
import com.chiran.drone.entities.LoadState;
import com.chiran.drone.repository.DroneRepository;

@Component
@EnableScheduling
public class ScheduledTasks {

	private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	private final DroneRepository droneRepository;

	public ScheduledTasks(DroneRepository droneRepository) {
		this.droneRepository = droneRepository;
	}

	@Scheduled(fixedRate = 5000)
	public void checkDroneBatteryLevel() {
		Iterable<Drone> drones = droneRepository.findAll();
		drones.forEach(drone -> logger.info(
				"Current Time: " + System.currentTimeMillis() +
				" Drone: " + drone.getSerial() +
				" Battery Level: "  + drone.getBatteryCapacity()
				));
	}

	@Scheduled(fixedRate = 15000)
	public void stopDroneLoadingWhenBatteryLow() {
		Iterable<Drone> drones = droneRepository.findAll();
		drones.forEach(drone -> {
					if(drone.getBatteryCapacity() <= 25) {
						drone.setState(LoadState.IDLE);
						droneRepository.save(drone);
					}
				});
	}

}
