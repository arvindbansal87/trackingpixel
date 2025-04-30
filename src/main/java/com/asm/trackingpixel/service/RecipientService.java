package com.asm.trackingpixel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.trackingpixel.entity.Recipient;
import com.asm.trackingpixel.repository.RecipientRepository;

@Service
public class RecipientService {
	
	@Autowired
    private RecipientRepository repository;
    
    public Recipient createRecipient( Recipient recipient) {
		return  repository.save(recipient);
	}

}
