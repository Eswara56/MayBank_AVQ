package org.maybank.com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// fetch the files from the table
@Entity
@Table(name = "T_EGL_BASE_SYSTEMS")
public class SystemConfig {

	@Id
    @Column(name = "S_NO") // Assuming S_NO is a unique identifier for each row
    private Integer sNo;
    @Column(name = "APPL_CODE") 
    private String applCode;

    @Column(name = "HEADER_FILE")
    private String headerFile;

    @Column(name = "DETAIL_FILE")
    private String detailFile;

    @Column(name = "FOOTER_FILE")
    private String footerFile;
    
    public Integer getsNo() {
		return sNo;
	}

	public void setsNo(Integer sNo) {
		this.sNo = sNo;
	}
	public String getApplCode() {
		return applCode;
	}

	public void setApplCode(String applCode) {
		this.applCode = applCode;
	}

	public String getHeaderFile() {
		return headerFile;
	}

	public void setHeaderFile(String headerFile) {
		this.headerFile = headerFile;
	}

	public String getDetailFile() {
		return detailFile;
	}

	public void setDetailFile(String detailFile) {
		this.detailFile = detailFile;
	}

	public String getFooterFile() {
		return footerFile;
	}

	public void setFooterFile(String footerFile) {
		this.footerFile = footerFile;
	}

	

}