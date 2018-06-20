package com.test.SpringIntegrationSmbTest.completion.advice;

import java.io.File;

import org.springframework.integration.handler.advice.AbstractRequestHandlerAdvice;
import org.springframework.messaging.Message;

public class TempFileCleanupAdvice extends AbstractRequestHandlerAdvice {
	
	public TempFileCleanupAdvice() {
		super();
	}

	@Override
	protected Object doInvoke(ExecutionCallback callback, Object target, Message<?> message) throws Exception {
		
		Object result = callback.execute();
		Object payload = message.getPayload();
		
		if((payload != null) && (payload instanceof File)) {
			try {
				File tempFile = (File)payload;
				
				tempFile.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
