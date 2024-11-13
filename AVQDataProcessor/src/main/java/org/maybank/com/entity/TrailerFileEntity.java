package org.maybank.com.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="T_EGL_INTRF_TRLR_DLY")
public class TrailerFileEntity {
	
	@Id
	 @GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	@Column(name = "RCD_TP_IND")
	private String recordTypeIndicator; // RCD_TP_IND
    @Column(name = "TOT_DR_LINE", precision = 6, scale = 0)
    private Integer totalDebitLines; // TOT_DR_LINE
    @Column(name = "TOT_CR_LINE", precision = 6, scale = 0)
    private Integer totalCreditLines; // TOT_CR_LINE
    @Column(name = "TOT_DR_AMT", precision = 17, scale = 2)
    private BigDecimal totalDebitAmount; // TOT_DR_AMT
    @Column(name = "TOT_CR_AMT", precision = 17, scale = 2)
    private BigDecimal totalCreditAmount; // TOT_CR_AMT
    @Column(name = "FILR_1")
    private String filler; // FILR_1
    @Column(name = "APPLN_CODE")
    private String applicationCode; // APPLN_CODE
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRecordTypeIndicator() {
		return recordTypeIndicator;
	}
	public void setRecordTypeIndicator(String recordTypeIndicator) {
		this.recordTypeIndicator = recordTypeIndicator;
	}
	public Integer getTotalDebitLines() {
		return totalDebitLines;
	}
	public void setTotalDebitLines(Integer totalDebitLines) {
		this.totalDebitLines = totalDebitLines;
	}
	public Integer getTotalCreditLines() {
		return totalCreditLines;
	}
	public void setTotalCreditLines(Integer totalCreditLines) {
		this.totalCreditLines = totalCreditLines;
	}
	public BigDecimal getTotalDebitAmount() {
		return totalDebitAmount;
	}
	public void setTotalDebitAmount(BigDecimal totalDebitAmount) {
		this.totalDebitAmount = totalDebitAmount;
	}
	public BigDecimal getTotalCreditAmount() {
		return totalCreditAmount;
	}
	public void setTotalCreditAmount(BigDecimal totalCreditAmount) {
		this.totalCreditAmount = totalCreditAmount;
	}
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	public String getApplicationCode() {
		return applicationCode;
	}
	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}


}
