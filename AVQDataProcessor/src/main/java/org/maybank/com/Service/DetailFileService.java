package org.maybank.com.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.maybank.com.Repository.EGLDetailRepository;
import org.maybank.com.entity.EGLDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DetailFileService {

   

    @Autowired
    private EGLDetailRepository eglDetailRepository;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private MetadataService metadataService;

    
    public List<Map<String, Object>> processAndMapDetails(BufferedReader reader) {
        List<Map<String, Object>> dataDetail = new ArrayList<>();

        // Retrieve column names dynamically from the database table
        Set<String> columnNames = metadataService.getColumnNames("T_EGL_DOWNSTREAM_DETAILED");

        // Retrieve field configurations for mapping
        List<EGLDetail> detailConfig = processDetails();

        if (detailConfig == null || detailConfig.isEmpty()) {
            System.out.println("No detail configuration found.");
            return dataDetail;  // Return empty list if no configurations are found
        }

        try {
            String line = reader.readLine();
            while (line != null) {
                Map<String, Object> record = new HashMap<>();
                record.put("SYSTEM_ID", "PW");
                record.put("FILE_TYPE", "DETAIL");

                // Process each field in the detail based on the configuration
                for (EGLDetail fieldConfig : detailConfig) {
                    String fieldName = fieldConfig.getFIELD_NAME().trim();
                    int start = fieldConfig.getFIELD_START() - 1; // Convert to 0-based index
                    int length = fieldConfig.getFIELD_LENGTH();
                    int end = Math.min(start + length, line.length());

                    if (columnNames.contains(fieldName)) {
                        String fieldValue = line.substring(start, end).trim();
                        record.put(fieldName, fieldValue);
                    } else {
                        System.out.println("Skipping non-existent field: " + fieldName);
                    }
                }

                // Add the processed record to the list
                dataDetail.add(record);
                line = reader.readLine(); // Move to the next line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        saveAll(dataDetail);  // Save all processed records at once
        return dataDetail;  // Return the list of mapped records
    }

   
    public void saveAll(List<Map<String, Object>> dataDetail) {
        if (dataDetail.isEmpty()) {
            System.out.println("No detail records to save.");
            return;
        }

        // Use the keys from the first record to construct the SQL statement dynamically
        Map<String, Object> firstRecord = dataDetail.get(0);

        StringBuilder sql = new StringBuilder("INSERT INTO T_EGL_DOWNSTREAM_DETAILED (");
        StringBuilder valuesPlaceholder = new StringBuilder(" VALUES (");

        for (String columnName : firstRecord.keySet()) {
            sql.append(columnName).append(", ");
            valuesPlaceholder.append(":").append(columnName).append(", ");
        }

        // Remove trailing commas
        sql.setLength(sql.length() - 2);
        valuesPlaceholder.setLength(valuesPlaceholder.length() - 2);

        sql.append(")").append(valuesPlaceholder).append(")");

        // Execute batch update
        jdbcTemplate.batchUpdate(sql.toString(), dataDetail.toArray(new Map[0]));

        System.out.println("Saved " + dataDetail.size() + " records to the database.");
    }

    
  

    public List<EGLDetail> processDetails() {
        String systemId = "PW";
        String fileType = "DETAIL";

        List<EGLDetail> eglDetailList = eglDetailRepository.findBySystemIdAndFileTypeOrderByFieldOrder(systemId, fileType);

        if (eglDetailList == null || eglDetailList.isEmpty()) {
            System.out.println("No field configurations found for SYSTEM_ID = " + systemId + " and FILE_TYPE = " + fileType);
        }
        return eglDetailList;
    }

  
}
