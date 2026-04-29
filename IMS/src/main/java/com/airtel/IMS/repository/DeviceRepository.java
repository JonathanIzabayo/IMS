package com.airtel.IMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airtel.IMS.model.Device;

public interface DeviceRepository
extends JpaRepository<Device, Integer> {

}