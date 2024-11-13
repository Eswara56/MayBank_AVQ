package org.maybank.com.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.maybank.com.Repository.TrailerFileRepository;
import org.maybank.com.entity.DetailFileEntity;
import org.maybank.com.entity.TrailerFileEntity;
import org.maybank.com.util.Field;
import org.maybank.com.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrailerFileService {

	@Autowired
	private TrailerFileRepository footerFileRepository;
	// Define fields for TRAILER layout
	public static List<Field> defineTrailerLayout() {
		return List.of(new Field(1, 1), // Record Type
				new Field(2, 6), // Total No of Debit Lines
				new Field(8, 6), // Total No of Credit Lines
				new Field(14, 17), // Total Debit Amounts
				new Field(31, 17), // Total Credit Amounts
				new Field(48, 79), // Filler
				new Field(127, 2) // Type of Application
		);
	}

	// Process file content and map it to Trailer entity
	public List<TrailerFileEntity> processAndMapFooters(BufferedReader reader) {
		List<TrailerFileEntity> tarilerData = new ArrayList<TrailerFileEntity>();
		try {
			String line = reader.readLine();

			while (line != null) {
				List<String> extractedFields = FileUtils.processFile(line, defineTrailerLayout());
				tarilerData.add(mapToTrailer(extractedFields));
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tarilerData;
	}

	// Map extracted fields to Trailer entity
	private TrailerFileEntity mapToTrailer(List<String> fields) {
		TrailerFileEntity trailer = new TrailerFileEntity();
		trailer.setRecordTypeIndicator(fields.get(0));
		trailer.setTotalDebitLines(parseInteger(fields.get(1)));
		trailer.setTotalCreditLines(parseInteger(fields.get(2)));
		trailer.setTotalDebitAmount(parseBigDecimal(fields.get(3)));
		trailer.setTotalCreditAmount(parseBigDecimal(fields.get(4)));
		trailer.setFiller(fields.get(5));
		trailer.setApplicationCode(fields.get(6));
		return trailer;
	}

	// Helper method to parse integer fields safely
	private Integer parseInteger(String field) {
		try {
			return Integer.parseInt(field);
		} catch (NumberFormatException e) {
			return null; // or handle as per your application's requirements
		}
	}

	// Helper method to parse BigDecimal fields safely
	private BigDecimal parseBigDecimal(String field) {
		try {
			return new BigDecimal(field).movePointLeft(2); // Adjust for two decimal places
		} catch (NumberFormatException e) {
			return null; // or handle as per your application's requirements
		}
	}

	// Save list of Trailer entities to database
	public void saveAll(List<TrailerFileEntity> trailers) {
//		footerFileRepository.saveAll(trailers);
	}
}
