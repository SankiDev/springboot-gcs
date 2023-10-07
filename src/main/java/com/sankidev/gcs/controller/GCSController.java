package com.sankidev.gcs.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sankidev.gcs.service.GCSService;

@RestController
@RequestMapping("/api")
public class GCSController {

	@Autowired
	private GCSService gcsService;

	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam MultipartFile file) throws IOException {

		boolean uploaded = gcsService.upload(file);
		if (uploaded) {
			return ResponseEntity.ok("File uploaded successfully");
		} else {
			return ResponseEntity.ok("File uploaded successfully");
		}
	}
}
