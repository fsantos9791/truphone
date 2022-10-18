package com.truphone.api.devices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.truphone.api.devices.entity.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long>{
	
	List<Device> findAllByDeviceBrand(String deviceBrand);

}
