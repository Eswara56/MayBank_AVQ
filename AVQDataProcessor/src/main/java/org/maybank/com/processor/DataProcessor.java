package org.maybank.com.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.maybank.com.Repository.EGLDetailRepository;
import org.maybank.com.Repository.SystemConfigRepository;
import org.maybank.com.Service.DetailFileService;
import org.maybank.com.Service.HeaderFileService;
import org.maybank.com.Service.TrailerFileService;
import org.maybank.com.entity.DetailFileEntity;
import org.maybank.com.entity.EGLDetail;
import org.maybank.com.entity.HeaderFileEntity;
import org.maybank.com.entity.SystemConfig;
import org.maybank.com.entity.TrailerFileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataProcessor {
	@Autowired
	private SystemConfigRepository systemConfigRepository;
	@Autowired
	private HeaderFileService headerFileService;
	@Autowired
	private DetailFileService detailFileService;
	@Autowired
	private TrailerFileService trailerFileService;
	@Autowired
	private	EGLDetailRepository eglDetailRepository;  
	

    public void processFiles() {
        // Assuming we are retrieving for APPL_CODE = "PW"
        String applCode = "PW";
        
        // Retrieve the system configuration for the specified APPL_CODE
        SystemConfig systemConfig = systemConfigRepository.findByApplCode(applCode);
        
        if (systemConfig == null) {
            throw new RuntimeException("System configuration for '" + applCode + "' not found in database");
        }
        
        // Retrieve paths for each file type
        String baseDirectory = "D:/Work/AvqFiles/"; // Base directory where files are located
        String headerFilePath = baseDirectory + systemConfig.getHeaderFile();
        String detailFilePath = baseDirectory + systemConfig.getDetailFile();
        String trailerFilePath = baseDirectory + systemConfig.getFooterFile();
        System.out.println("Header File Path: " + headerFilePath);
        System.out.println("Detail File Path: " + detailFilePath);
        System.out.println("Footer File Path: " + trailerFilePath);
        // Process each file using the retrieved paths
        processFile(headerFilePath,detailFilePath,trailerFilePath); 
    }
	
	public void processFile(String headerFilePath1, String detailFilePath1, String footerFilePath1) {
	    try {
	        // Process Header File
	        try (BufferedReader headerReader = new BufferedReader(new FileReader(headerFilePath1))) {
	            List<HeaderFileEntity> headers = headerFileService.processAndMapHeaders(headerReader);
	            headerFileService.saveAll(headers); // Save to target database
	        }

	        // Process Detail File
	        try (BufferedReader detailReader = new BufferedReader(new FileReader(detailFilePath1))) {
	            List<DetailFileEntity> details = detailFileService.processAndMapDetails(detailReader);
	            detailFileService.saveAll(details); // Save to target database
	        }

	        // Process Footer File
	        try (BufferedReader footerReader = new BufferedReader(new FileReader(footerFilePath1))) {
	            List<TrailerFileEntity> footers = trailerFileService.processAndMapFooters(footerReader);
	            trailerFileService.saveAll(footers); // Save to target database
	        }

	    } catch (IOException e) {
	        System.err.println("Error processing files: " + e.getMessage());
	    }
	    
	}
	    
	    
	    public void processDetails() {
	    	
	    String 	systemId="PW";
	    String fileType="DETAIL";
	        // Retrieve field configurations from the database by systemId and fileType, ordered by fieldOrder
	        List<EGLDetail> eglDetailList = eglDetailRepository.findBySystemIdAndFileTypeOrderByFieldOrder(systemId, fileType);

	        // Check if the list is null or empty and handle it
	        if (eglDetailList == null || eglDetailList.isEmpty()) {
	            System.out.println("No field configurations found for SYSTEM_ID = '" + systemId + "' and FILE_TYPE = '" + fileType + "'");
	            return;
	        }

	        // Extract field names in order
	        for (EGLDetail field : eglDetailList) {
	            if (field != null && field.getFIELD_NAME() != null) {
	                System.out.println("Field Name: " + field.getFIELD_NAME() + ", Order: " + field.getFIELD_ORDER());

		            System.out.println(field.toString()); 
	            } else {
	                System.out.println("Skipping null field in eglDetailList");
	            }
	            
	        } 
	}
	
		
	}

	

