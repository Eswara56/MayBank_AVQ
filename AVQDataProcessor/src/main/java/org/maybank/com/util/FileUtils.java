package org.maybank.com.util;

import java.util.ArrayList;
import java.util.List;

public class FileUtils {

// Common method to extract fields based on layout
public static List<String> processFile(String text, List<Field> fields) {
    List<String> extractedFields = new ArrayList<>();
    System.out.println("==========================="+text);
    for (int i = 0; i < fields.size(); i++) {
        Field field = fields.get(i);
        int start = field.startPosition - 1;  // Convert to 0-based index
        int end = start + field.length;

        // Check if the start is within bounds
     
        if (start >= text.length()) {
            extractedFields.add("");  // Add empty if out of bounds
            System.out.println("Field " + (i + 1) + ": [Not Available]");
            continue;
        }

        // Adjust the end position if it exceeds the string length
        end = Math.min(end, text.length());

        // Extract the substring
        String fieldData = text.substring(start, end).trim();
        extractedFields.add(fieldData);
        System.out.println("Field " + (i + 1) + ": " + fieldData);
    }
    
    return extractedFields;
}
}


// Common method to extract fields based on layout
//public static List<String> processFile(String text, List<Field> fields) {
//  List<String> extractedFields = new ArrayList<>();
//  
//  for (Field field : fields) {
//      int start = field.startPosition - 1;  // Convert to 0-based index
//      int end = Math.min(start + field.length, text.length());
//
//      // Check if start is within bounds
//      if (start >= text.length()) {
//          extractedFields.add("");  // Add empty if out of bounds
//      } else {
//          // Extract substring and trim any extra spaces
//          String fieldData = text.substring(start, end).trim();
//          extractedFields.add(fieldData);
//      }
//  }
//  
//  return extractedFields;
//}
//}