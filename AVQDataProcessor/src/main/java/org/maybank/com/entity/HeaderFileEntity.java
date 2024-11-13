package org.maybank.com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="T_EGL_INTRF_HDR_DLY")
public class HeaderFileEntity {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "RCD_TP_IND")
	private String recordTypeIndicator; // RCD_TP_IND
	 @Column(name = "FILE_ID")
    private String fileId; // FILE_ID
	    @Column(name = "APPLN_PROC_DTE")
    private Integer  applicationProcessingDate; // APPLN_PROC_DTE
	    @Column(name = "COMPLN_STS_IND")
    private String completionStatusIndicator; // COMPLN_STS_IND
	    @Column(name = "DTL_DESC")
    private String description; // DTL_DESC
	    @Column(name = "LAST_PROC_DTE")
    private Integer lastProcessDate; // LAST_PROC_DTE
	    @Column(name = "NEXT_PROC_DTE")
    private Integer nextProcessDate; // NEXT_PROC_DTE
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
		public String getFileId() {
			return fileId;
		}
		public void setFileId(String fileId) {
			this.fileId = fileId;
		}
		public Integer getApplicationProcessingDate() {
			return applicationProcessingDate;
		}
		public void setApplicationProcessingDate(Integer applicationProcessingDate) {
			this.applicationProcessingDate = applicationProcessingDate;
		}
		public String getCompletionStatusIndicator() {
			return completionStatusIndicator;
		}
		public void setCompletionStatusIndicator(String completionStatusIndicator) {
			this.completionStatusIndicator = completionStatusIndicator;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Integer getLastProcessDate() {
			return lastProcessDate;
		}
		public void setLastProcessDate(Integer lastProcessDate) {
			this.lastProcessDate = lastProcessDate;
		}
		public Integer getNextProcessDate() {
			return nextProcessDate;
		}
		public void setNextProcessDate(Integer nextProcessDate) {
			this.nextProcessDate = nextProcessDate;
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
