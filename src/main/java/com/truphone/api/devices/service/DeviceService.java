package com.truphone.api.devices.service;

import java.util.List;

import com.truphone.api.devices.entity.Device;
import com.truphone.api.devices.model.DeviceDto;

/**
 * @author windows
 *
 */
public interface DeviceService {
	/**
	 * @param device
	 * @return
	 */
	DeviceDto addDevice(DeviceDto device);

	/**
	 * @param id
	 * @return
	 */
	DeviceDto getDeviceById(Long id);

	/**
	 * @return
	 */
	List<DeviceDto> getAllDevices();

	
	/**
	 * @param device
	 * @param id
	 * @return
	 */
	DeviceDto updateDevice(DeviceDto device,Long id);


	/**
	 * @param device
	 * @param id
	 * @return
	 */
	DeviceDto patchDevice(DeviceDto device,Long id);

	/**
	 * @param id
	 */
	void deleteDevice(Long id);

	/**
	 * @param brand
	 * @return
	 */
	List<DeviceDto> getAllDeviceByBrand(String brand);

}
