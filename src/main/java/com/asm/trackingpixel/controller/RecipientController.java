package com.asm.trackingpixel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asm.trackingpixel.entity.Recipient;
import com.asm.trackingpixel.service.RecipientService;
import com.asm.trackingpixel.util.CommonUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/recipient")
public class RecipientController {
	
	@Autowired
    private RecipientService recipientService;
    
	@GetMapping("/pixel/url")
    public String getPixelUrl(@RequestParam String email, HttpServletRequest request) {
        String pixelId = CommonUtil.getUniquiId();
        createRecipient(email,pixelId);
        
        String pixelUrl = CommonUtil.getHost(request) + "/pixel.png?id=" + pixelId;
        return "<img src='" + pixelUrl + "' width='1' height='1' style='display:none;' />";
    }
    
    //Added for testing
    @PostMapping("/create")
    public void createRecipient(@RequestParam String email) {
        String pixelId = CommonUtil.getUniquiId();
        createRecipient(email,pixelId);
        
    }
    private void createRecipient(String email, String pixelId){
    	Recipient recipient = new Recipient();
        recipient.setEmail(email);
        recipient.setPixelId(pixelId);
        recipientService.createRecipient(recipient);
    }
    
}