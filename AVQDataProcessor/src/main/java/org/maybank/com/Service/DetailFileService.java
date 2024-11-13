package org.maybank.com.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.maybank.com.Repository.DetailFileRepository;
import org.maybank.com.entity.DetailFileEntity;
import org.maybank.com.util.Field;
import org.maybank.com.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailFileService {
	@Autowired
	private DetailFileRepository detailFileRepository;
	
	 public static List<Field> defineDetailLayout() {
	        return List.of(
	            new Field(1, 1),
	            new Field(2, 3),
	            new Field(5, 1),
	            new Field(6, 3),
	            new Field(9, 3),
	            new Field(12, 3),
	            new Field(15, 6),
	            new Field(21, 8),
	            new Field(29, 8),
	            new Field(37, 1),
	            new Field(38, 1),
	            new Field(39, 15),
	            new Field(54, 30),
	            new Field(84, 3),
	            new Field(87, 15),
	            new Field(102, 25),
	            new Field(127, 2)
	        );
	    }

	    public List<DetailFileEntity> processAndMapDetails( BufferedReader reader) {
	    	List<DetailFileEntity> dataadetail= new ArrayList<DetailFileEntity>();
     		try {
     			String line = reader.readLine();

     			while (line != null) {
     				 List<String> extractedFields = FileUtils.processFile(line, defineDetailLayout());
     				dataadetail.add(mapToDetail(extractedFields));
     				line = reader.readLine();
     			}

     			reader.close();
     		} catch (IOException e) {
     			e.printStackTrace();
     		}
     		 return dataadetail;
	       
	    }
    
	    private DetailFileEntity mapToDetail(List<String> fields) {
	    	DetailFileEntity detail = new DetailFileEntity();
	    	
	     detail.setRCD_TP_IND(fields.get(0));
	        detail.setCO_CODE(fields.get(1));
	        detail.setBK_TP_IND(fields.get(2));
	        detail.setCURCY_3_CODE(fields.get(3));
	        detail.setUNIT_NO(fields.get(4));
	        detail.setSECT_NO(fields.get(5));
	        detail.setAC_6_NO(fields.get(6));
	        detail.setANSYS_CODE(fields.get(7));
	        detail.setEFF_DTE(fields.get(8));
	        detail.setRSDT_TP_IND(fields.get(9));
	        detail.setDR_CR_IND(fields.get(10)); 
	        // Parse Posting Amount with two decimal places
	        String postingAmountStr = fields.get(11);
	        BigDecimal postingAmount = new BigDecimal(postingAmountStr).movePointLeft(2); 
	        detail.setPOST_AMT(postingAmount);  
	        detail.setDTL_DESC(fields.get(12));
	        detail.setTRN_3_CODE(fields.get(13));
	        detail.setREF_NO(fields.get(14));
	        detail.setDTL_FILR(fields.get(15));
	        detail.setAPPLN_CODE(fields.get(16));
	        return detail;
	    }

	   
    public void saveAll(List<DetailFileEntity> details) {     
//      detailFileRepository.saveAll(details);
       
    }
	

}
