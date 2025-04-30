package com.asm.trackingpixel.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.asm.trackingpixel.entity.OpenEvent;
import com.asm.trackingpixel.service.OpenEventService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class OpenEventController
{
	@Autowired
	private OpenEventService openEventService;
	
	@GetMapping("/events")
    public String getEvents(Model model) {
        model.addAttribute("events", openEventService.getEvents());
        return "events";
    }
    
	
	@GetMapping("/events/{id}") 
	public String getEvent(@PathVariable String id,Model model) { 
		model.addAttribute("events",openEventService.getEvent(id));
		return "events"; 
	}
	 
    
    @GetMapping(value = "/pixel.png", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getPixel(@RequestParam String id,
    											HttpServletRequest request) throws IOException {
    	
    	createEvent(id, request.getHeader("User-Agent"));
    	
        ClassPathResource imgFile = new ClassPathResource("static/transparent.png");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(bytes);
    }
    
	@SuppressWarnings("unchecked")
	private OpenEvent createEvent(String id, String userAgent) {
    	String ip = null;
        String city = "";
        String country = "";

        // Fetch location via IP Geolocation API
        try {
            RestTemplate restTemplate = new RestTemplate();
            ip=restTemplate.getForObject("https://api.ipify.org", String.class);
            String apiUrl = "http://ip-api.com/json/" + ip;
            
			Map<String, Object> response = restTemplate.getForObject(apiUrl, Map.class);
            city = (String) response.get("city");
            country = (String) response.get("country");
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        
        OpenEvent event = new OpenEvent();
        event.setPixelId(id);
        event.setIp(ip);
        event.setUserAgent(userAgent);
        event.setTimestamp(LocalDateTime.now());
        event.setCity(city);
        event.setCountry(country);
        return openEventService.createEvent(event);
    }
}

