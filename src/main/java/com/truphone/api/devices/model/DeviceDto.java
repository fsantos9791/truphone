package com.truphone.api.devices.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.time.LocalDateTime;

import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.truphone.api.devices.controller.DeviceController;
import com.truphone.api.devices.entity.Device;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeviceDto extends RepresentationModel<DeviceDto>{
	private Long deviceId;
	
	private String deviceName;
	
	private String deviceBrand;
	
	private LocalDateTime creatonTime;

	public DeviceDto(Device device) {
		this.deviceId=device.getDeviceId();
		this.deviceName=device.getDeviceName();
		this.deviceBrand=device.getDeviceBrand();
		this.creatonTime=device.getCreatonTime();
		this.add(linkTo(methodOn(DeviceController.class).getDevice(deviceId)).withSelfRel());
		this.add(linkTo(methodOn(DeviceController.class).getDevices()).withRel(IanaLinkRelations.COLLECTION));
	}

	@JsonIgnore
	public Device getDevice() {
		return Device.builder().deviceId(deviceId).deviceName(deviceName).deviceBrand(deviceBrand).creatonTime(creatonTime).build();
	}
}
