package com.truphone.api.devices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truphone.api.devices.exception.DeviceNotFoundException;
import com.truphone.api.devices.model.DeviceDto;
import com.truphone.api.devices.service.DeviceService;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;

	@GetMapping
	public ResponseEntity<List<DeviceDto>> getDevices() {
		try {
			List<DeviceDto> allDevices = deviceService.getAllDevices();
			return new ResponseEntity<>(allDevices, HttpStatus.OK);
		} catch (DeviceNotFoundException e) {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<DeviceDto> getDevice(@PathVariable("id") Long id) {
		try {
			DeviceDto deviceById = deviceService.getDeviceById(id);
			return new ResponseEntity<>(deviceById, HttpStatus.OK);
		} catch (DeviceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<DeviceDto> insertDevice(@RequestBody DeviceDto device) {
		DeviceDto addDevice = deviceService.addDevice(device);
		return new ResponseEntity<>(addDevice, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDevice(@PathVariable("id") Long id) {
		try {
			deviceService.deleteDevice(id);
			return ResponseEntity.ok().build();
		} catch (DeviceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DeviceDto> updateDevice(@PathVariable("id") Long id, @RequestBody DeviceDto device) {
		try {
			DeviceDto deviceById = deviceService.updateDevice(device,id);
			return new ResponseEntity<>(deviceById, HttpStatus.OK);
		} catch (DeviceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<DeviceDto> patchDevice(@PathVariable("id") Long id, @RequestBody DeviceDto device) {
		try {
			DeviceDto deviceById = deviceService.patchDevice(device,id);
			return new ResponseEntity<>(deviceById, HttpStatus.OK);
		} catch (DeviceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	

}
