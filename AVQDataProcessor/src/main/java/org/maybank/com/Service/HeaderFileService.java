package org.maybank.com.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.maybank.com.Repository.HeaderFileRepository;
import org.maybank.com.entity.DetailFileEntity;
import org.maybank.com.entity.HeaderFileEntity;
import org.maybank.com.util.Field;
import org.maybank.com.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HeaderFileService {

	
	
	  @Autowired
	    private HeaderFileRepository headerFileRepository;
	  
	// Define fields for HEADER layout
	    public static List<Field> defineHeaderLayout() {
	        return List.of(
	            new Field(1, 1),
	            new Field(2, 10),
	            new Field(12, 8),
	            new Field(20, 1),
	            new Field(21, 30),
	            new Field(51, 8),
	            new Field(59, 8),
	            new Field(67, 60),
	            new Field(127, 2)
	        );
	    }

	    public List<HeaderFileEntity> processAndMapHeaders(BufferedReader reader) {
	    	List<HeaderFileEntity> headerData= new ArrayList<HeaderFileEntity>();
     		try {
     			String line = reader.readLine();
     			while (line != null) {
     				 List<String> extractedFields = FileUtils.processFile(line, defineHeaderLayout());
     				headerData.add(mapToHeader(extractedFields));
     				line = reader.readLine();
     			}

     			reader.close();
     		} catch (IOException e) {
     			e.printStackTrace();
     		}
     		 return headerData;
	    }

	    // Map extracted fields to Header entity
	    private HeaderFileEntity mapToHeader(List<String> fields) {
	    	HeaderFileEntity header = new HeaderFileEntity();
	        header.setRecordTypeIndicator(fields.get(0));
	        header.setFileId(fields.get(1));
	        header.setApplicationProcessingDate(Integer.parseInt(fields.get(2)));
	        header.setCompletionStatusIndicator(fields.get(3));
	        header.setDescription(fields.get(4));
	        header.setLastProcessDate(Integer.parseInt(fields.get(5)));
	        header.setNextProcessDate(Integer.parseInt(fields.get(6)));
	        header.setFiller(fields.get(7));
	        header.setApplicationCode(fields.get(8));
	        return header;
	    }

	    public void saveAll(List<HeaderFileEntity> headers) {
//	        headerFileRepository.saveAll(headers);
	    }
	

}
