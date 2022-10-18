package com.truphone.api.devices.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.truphone.api.devices.entity.Device;

@DataJpaTest
class DeviceRepositoryTest {
	
	@Autowired
	private DeviceRepository deviceRepository;

	@Test
	void testAddDevice() {
		Device device = Device.builder().deviceBrand("xiaomi").deviceName("A5").creatonTime(LocalDateTime.now()).build();
		Device savedDevice = deviceRepository.save(device);
		Assertions.assertNotNull(savedDevice);
		Assertions.assertTrue(savedDevice.getDeviceId()>0);
	}
	
	@Test
	void testfindByBrandName() {
		String deviceBrand = "xiaomi";
		deviceRepository.save(Device.builder().deviceBrand(deviceBrand).deviceName("A5").creatonTime(LocalDateTime.now()).build());
		deviceRepository.save(Device.builder().deviceBrand(deviceBrand).deviceName("A6").creatonTime(LocalDateTime.now()).build());
		deviceRepository.save(Device.builder().deviceBrand("nokia").deviceName("5").creatonTime(LocalDateTime.now()).build());
		
		List<Device> findAllByDeviceBrand = deviceRepository.findAllByDeviceBrand(deviceBrand);
		
		Assertions.assertEquals(2, findAllByDeviceBrand.size());
		Assertions.assertEquals(deviceBrand, findAllByDeviceBrand.get(0).getDeviceBrand());
		Assertions.assertEquals(deviceBrand, findAllByDeviceBrand.get(1).getDeviceBrand());
		
	}
	
	

}
