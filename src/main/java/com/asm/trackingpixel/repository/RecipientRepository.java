package com.asm.trackingpixel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asm.trackingpixel.entity.Recipient;

public interface RecipientRepository extends JpaRepository<Recipient, Long> {
}
