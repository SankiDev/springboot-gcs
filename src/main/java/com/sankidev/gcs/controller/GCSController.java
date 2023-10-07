package com.sankidev.gcs.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/list")
	public ResponseEntity<List<String>> listFiles() {
		List<String> files = gcsService.listFiles();
		return ResponseEntity.ok(files);
	}
	
	@GetMapping("/read/{fileName}")
	public ResponseEntity<String> downloadFile(@PathVariable String fileName) {
		String file = gcsService.read(fileName);
		return ResponseEntity.ok(file);

	}
}
