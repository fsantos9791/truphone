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
	

}
