package com.truphone.api.devices.repository;

import java.time.LocalDateTime;

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

}
