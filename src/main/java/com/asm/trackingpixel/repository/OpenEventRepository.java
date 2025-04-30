package com.asm.trackingpixel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asm.trackingpixel.entity.OpenEvent;

public interface OpenEventRepository extends JpaRepository<OpenEvent, Long>
{
	List<OpenEvent> findByPixelId(String pixelId);
}
