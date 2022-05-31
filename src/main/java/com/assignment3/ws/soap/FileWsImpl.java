package com.assignment3.ws.soap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;




public class FileWsImpl implements FileWs {

	@Override
	public void upload(DataHandler attachment) {
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		String path = "F://McGill//Courses//CCCS-425-Web Services//Assignment 3//test.jpg";
		
		try {
			//Will grab the stream and attach it to the outgoing soad message
			inputStream = attachment.getInputStream();
			outputStream = new FileOutputStream(new File(path));
			//declare a byte array to be used as a buffer
			byte[] b = new byte[100000];

			int byteRead = 0;
			
			//loop to read file from input stream until the end and write it to the output stream (-1 signifies the end of file)
			while((byteRead=inputStream.read(b))!=-1) {
				outputStream.write(b, 0, byteRead);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}

	@Override
	public DataHandler download() {
		//create data handler needed for the method and provide the path to file to be downloaded
		return new DataHandler(new FileDataSource(new File("F://McGill//Courses//CCCS-425-Web Services//Assignment 3//test.jpg")));
		
		
	}

	@Override
	public int[] fibonacciResponse() {
		int times = 10;
		int[] response = new int[10];
		
		for(int i = 0; i < times; i++) {
			if(i == 0 || i == 1) {
				response[i] = i;
			}else {
				response[i] = response[i-1] + response[i-2]; 
			}
		}
		
		return response;
	}

}
