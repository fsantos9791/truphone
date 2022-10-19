package com.truphone.api.devices.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deviceId;
	
	private String deviceName;
	
	private String deviceBrand;
	
	@Column(nullable = false)
	private LocalDateTime creatonTime;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device other = (Device) obj;
		if (creatonTime == null) {
			if (other.creatonTime != null)
				return false;
		} else if (!creatonTime.equals(other.creatonTime))
			return false;
		if (deviceBrand == null) {
			if (other.deviceBrand != null)
				return false;
		} else if (!deviceBrand.equals(other.deviceBrand))
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (deviceName == null) {
			if (other.deviceName != null)
				return false;
		} else if (!deviceName.equals(other.deviceName))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((creatonTime == null) ? 0 : creatonTime.hashCode());
		result = prime * result + ((deviceBrand == null) ? 0 : deviceBrand.hashCode());
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((deviceName == null) ? 0 : deviceName.hashCode());
		return result;
	}
	

}
