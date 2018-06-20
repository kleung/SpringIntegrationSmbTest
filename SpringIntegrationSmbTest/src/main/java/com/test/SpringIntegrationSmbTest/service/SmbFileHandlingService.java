package com.test.SpringIntegrationSmbTest.service;


import org.springframework.messaging.Message;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

public class SmbFileHandlingService {
	
	public SmbFileHandlingService() {
		super();
	}
	
	public void handleMessage(Message<File> message) {
		Object payload = message.getPayload();
		
		if((payload != null) && (payload instanceof File)) {
			File localTempFile = (File) payload;
			byte[] fileBytes = null;
			
			try {
				fileBytes = FileCopyUtils.copyToByteArray(localTempFile);
				
				String fileContentString = new String(fileBytes);
				
				System.out.println(fileContentString);
			} catch (IOException ioe) {
				throw new RuntimeException(ioe.getMessage(), ioe);
			} finally {
				try {
					localTempFile.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
