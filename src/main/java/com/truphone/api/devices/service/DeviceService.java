package com.truphone.api.devices.service;

import java.util.List;

import com.truphone.api.devices.entity.Device;

/**
 * @author windows
 *
 */
public interface DeviceService {
	/**
	 * @param device
	 * @return
	 */
	Device addDevice(Device device);

	/**
	 * @param id
	 * @return
	 */
	Device getDeviceById(Long id);

	/**
	 * @return
	 */
	List<Device> getAllDevices();

	
	/**
	 * @param device
	 * @param id
	 * @return
	 */
	Device updateDevice(Device device,Long id);


	/**
	 * @param device
	 * @param id
	 * @return
	 */
	Device patchDevice(Device device,Long id);

	/**
	 * @param id
	 */
	void deleteDevice(Long id);

	/**
	 * @param brand
	 * @return
	 */
	List<Device> getAllDeviceByBrand(String brand);

}
