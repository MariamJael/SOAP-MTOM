package com.assignment3.ws.soap;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


//annotation
@WebService
public interface FileWs {
	//definition of the upload method for this interface
	void upload(@WebParam(name="file") DataHandler attachment);
	//definition of the download method for this interface
	DataHandler download();
	//definition of fibonacci
	/*Annotated web method, result and param*/
	@WebMethod
	public @WebResult(name="response") /*FibonacciResponse*/int[] fibonacciResponse();

}
