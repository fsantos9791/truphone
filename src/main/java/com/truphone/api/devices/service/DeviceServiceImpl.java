package com.truphone.api.devices.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.truphone.api.devices.entity.Device;
import com.truphone.api.devices.exception.DeviceNotFoundException;
import com.truphone.api.devices.repository.DeviceRepository;

public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceRepository deviceRepository;

	@Override
	@Transactional
	public Device addDevice(Device device) {
		return deviceRepository.save(device);
	}

	@Override
	@Transactional
	public Device getDeviceById(Long id) {
		Optional<Device> findById = deviceRepository.findById(id);
		if (findById.isEmpty())
			throw new DeviceNotFoundException();
		return findById.get();
	}

	@Override
	@Transactional
	public List<Device> getAllDevices() {
		return deviceRepository.findAll();
	}

	@Override
	@Transactional
	public Device updateDevice(Device device, Long id) {
		Optional<Device> findById = deviceRepository.findById(id);
		if (findById.isEmpty())
			throw new DeviceNotFoundException();

		device.setDeviceId(id);
		return deviceRepository.save(device);
	}

	@Override
	@Transactional
	public Device patchDevice(Device device, Long id) {
		Optional<Device> findById = deviceRepository.findById(id);
		if (findById.isEmpty())
			throw new DeviceNotFoundException();
		if (device.getDeviceBrand() != null) {
			findById.get().setDeviceBrand(device.getDeviceBrand());
		}
		if (device.getDeviceName() != null) {
			findById.get().setDeviceName(device.getDeviceName());
		}
		return deviceRepository.save(device);
	}

	@Override
	public void deleteDevice(Long id) {
		Optional<Device> findById = deviceRepository.findById(id);
		if (findById.isEmpty())
			throw new DeviceNotFoundException();
		deviceRepository.delete(findById.get());

	}

	@Override
	public List<Device> getAllDeviceByBrand(String brand) {

		return deviceRepository.findAllByDeviceBrand(brand);
	}

}
