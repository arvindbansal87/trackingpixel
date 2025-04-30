package com.asm.trackingpixel.service; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.trackingpixel.entity.OpenEvent;
import com.asm.trackingpixel.repository.OpenEventRepository;

@Service
public class OpenEventService {
	
	@Autowired
    private OpenEventRepository repository;
    
    public List<OpenEvent> getEvents(){
		return repository.findAll();
	}
	
	public List<OpenEvent> getEvent(String id){
		return repository.findByPixelId(id);
	}
	
	public OpenEvent createEvent(OpenEvent openEvent) {
		return repository.save(openEvent);
	}

}
