package com.truphone.api.devices.service;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.truphone.api.devices.entity.Device;
import com.truphone.api.devices.exception.DeviceNotFoundException;
import com.truphone.api.devices.model.DeviceDto;
import com.truphone.api.devices.repository.DeviceRepository;

@ExtendWith(MockitoExtension.class)
class DeviceServiceImplTest {

	@Mock
	private DeviceRepository deviceRepository;

	@InjectMocks
	private DeviceServiceImpl DeviceServiceImpl;

	@Test
	void testGetAllDevices() {

		when(deviceRepository.findAll())
				.thenReturn(Arrays.asList(Device.builder().deviceId(1L).creatonTime(LocalDateTime.now()).build()));
		List<DeviceDto> allDevices = DeviceServiceImpl.getAllDevices();
		Assertions.assertEquals(1, allDevices.size());
	}

	@Test
	void testGetAllDevicesDeviceNotFoundException() {

		when(deviceRepository.findAll()).thenReturn(new ArrayList<>());
		Assertions.assertThrows(DeviceNotFoundException.class, () -> DeviceServiceImpl.getAllDevices());
	}
	

}
