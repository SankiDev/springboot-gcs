package com.sankidev.gcs.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;

@Service
public class GCSService {

	@Value("${gcp.bucket.name}")
	private String bucketName;

	@Autowired
	private Storage storage;

	public boolean upload(MultipartFile file) throws IOException {
		BlobId blobId = BlobId.of(bucketName, file.getOriginalFilename());
		BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(file.getContentType()).build();
		storage.create(blobInfo, file.getBytes());
		return true;
	}
	
	public List<String> listFiles() {
        List<String> files = new ArrayList<>();
        Page<Blob> blobs = storage.list(bucketName);
        for (Blob blob : blobs.iterateAll()) {
        	files.add(blob.getName());
        }
        return files;
    }
	
	public String read(String fileName) {
		Blob blob = storage.get(bucketName, fileName);
		ByteArrayResource resource = new ByteArrayResource(blob.getContent());
		return new String(resource.getByteArray());
	}
}
