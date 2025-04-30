package com.asm.trackingpixel.entity;

import jakarta.persistence.*;


@Entity
public class Recipient
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String pixelId;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPixelId() {
		return pixelId;
	}
	public void setPixelId(String pixelId) {
		this.pixelId = pixelId;
	}   

}
