package com.sankidev.gcs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@Configuration
public class GcsConfig {

	@Bean
	public Storage getStorage() {
		Storage storageClient = StorageOptions.newBuilder().setHost("http://localhost:9093/")
				.setProjectId("test-project").setCredentials(NoCredentials.getInstance()).build().getService();
		return storageClient;
	}

	@Bean
	public CredentialsProvider credentialsProvider() {
		return () -> NoCredentialsProvider.create().getCredentials();
	}
}
