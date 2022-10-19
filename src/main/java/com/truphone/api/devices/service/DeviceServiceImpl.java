package com.truphone.api.devices.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truphone.api.devices.entity.Device;
import com.truphone.api.devices.exception.DeviceNotFoundException;
import com.truphone.api.devices.model.DeviceDto;
import com.truphone.api.devices.repository.DeviceRepository;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceRepository deviceRepository;

	@Override
	@Transactional
	public DeviceDto addDevice(DeviceDto deviceDto) {
		deviceDto.setDeviceId(null);
		deviceDto.setCreatonTime(LocalDateTime.now());
		Device device = deviceRepository.save(deviceDto.getDevice());
		return new DeviceDto(device);
	}

	@Override
	@Transactional
	public DeviceDto getDeviceById(Long id) {
		Optional<Device> findById = deviceRepository.findById(id);
		if (findById.isEmpty())
			throw new DeviceNotFoundException();
		return new DeviceDto(findById.get());
	}

	@Override
	@Transactional
	public List<DeviceDto> getAllDevices() {
		List<Device> findAll = deviceRepository.findAll();
		if (findAll.isEmpty())
			throw new DeviceNotFoundException();
		return findAll.stream().map(device -> new DeviceDto(device)).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public DeviceDto updateDevice(DeviceDto device, Long id) {
		Optional<Device> findById = deviceRepository.findById(id);
		if (findById.isEmpty())
			throw new DeviceNotFoundException();

		device.setDeviceId(id);
		device.setCreatonTime(findById.get().getCreatonTime());
		Device savedDevice = deviceRepository.save(device.getDevice());
		return new DeviceDto(savedDevice);
	}

	@Override
	@Transactional
	public DeviceDto patchDevice(DeviceDto deviceDto, Long id) {
		Optional<Device> findById = deviceRepository.findById(id);
		if (findById.isEmpty())
			throw new DeviceNotFoundException();
		if (deviceDto.getDeviceBrand() != null) {
			findById.get().setDeviceBrand(deviceDto.getDeviceBrand());
		}
		if (deviceDto.getDeviceName() != null) {
			findById.get().setDeviceName(deviceDto.getDeviceName());
		}
		Device savedDevice = deviceRepository.save(findById.get());
		return new DeviceDto(savedDevice);
	}

	@Override
	public void deleteDevice(Long id) {
		Optional<Device> findById = deviceRepository.findById(id);
		if (findById.isEmpty())
			throw new DeviceNotFoundException();
		deviceRepository.delete(findById.get());

	}

	@Override
	public List<DeviceDto> getAllDeviceByBrand(String brand) {
		List<Device> findAllByDeviceBrand = deviceRepository.findAllByDeviceBrand(brand);
		if (findAllByDeviceBrand.isEmpty()) {
			throw new DeviceNotFoundException();
		}
		return findAllByDeviceBrand.stream().map(device -> new DeviceDto(device)).collect(Collectors.toList());
	}

}
