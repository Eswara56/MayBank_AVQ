package org.maybank.com;

import java.io.IOException;

import org.maybank.com.Service.DetailFileService;
import org.maybank.com.processor.DataProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AvqDataProcessorApplication {

	

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(AvqDataProcessorApplication.class, args);
DataProcessor data=context.getBean(DataProcessor.class);
	data.processFiles();

//data.processDetails();


		
	}

}
