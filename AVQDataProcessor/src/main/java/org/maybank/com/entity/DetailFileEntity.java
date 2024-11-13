package org.maybank.com.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="T_EGL_INTRF_AT_DLY")
public class DetailFileEntity {
	

	@Id
	 @GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	  @Column(name = "RCD_TP_IND")
	private String RCD_TP_IND; // RCD_TP_IND
	  
	  @Column(name = "CO_CODE")
    private String CO_CODE; // CO_CODE
	  @Column(name = "BK_TP_IND")
    private String BK_TP_IND; // BK_TP_IND
	  @Column(name = "CURCY_3_CODE")
    private String CURCY_3_CODE; // CURCY_3_CODE
	   @Column(name = "UNIT_NO")
    private String UNIT_NO; // UNIT_NO
	    @Column(name = "SECT_NO")
    private String SECT_NO; // SECT_NO
	    @Column(name = "AC_6_NO")
    private String AC_6_NO; // AC_6_NO
	    @Column(name = "ANSYS_CODE")
    private String ANSYS_CODE; // ANYSIS_CODE
	    @Column(name = "EFF_DTE")
	  //  @Temporal(TemporalType.DATE)
    private String EFF_DTE; // EFF_DTE
	    @Column(name = "RSDT_TP_IND")
    private String RSDT_TP_IND; // RSDT_TP_IND
	    @Column(name = "DR_CR_IND")
    private String DR_CR_IND; // DR_CR_IND
	    @Column(name = "POST_AMT", precision = 17, scale = 2)
    private BigDecimal  POST_AMT; // POST_AMT
	    @Column(name = "DTL_DESC")
    private String DTL_DESC; // DTL_DESC
	    @Column(name = "TRN_3_CODE")
    private String TRN_3_CODE; // TRN_3_CODE
	    @Column(name = "REF_NO")
    private String REF_NO; // REF_NO
	    @Column(name = "DTL_FILR")
    private String DTL_FILR; // DTL_FILR
	    @Column(name = "APPLN_CODE")
    private String APPLN_CODE; // APPLN_CODE
  
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getRCD_TP_IND() {
			return RCD_TP_IND;
		}
		public void setRCD_TP_IND(String rCD_TP_IND) {
			RCD_TP_IND = rCD_TP_IND;
		}
		public String getCO_CODE() {
			return CO_CODE;
		}
		public void setCO_CODE(String cO_CODE) {
			CO_CODE = cO_CODE;
		}
		public String getBK_TP_IND() {
			return BK_TP_IND;
		}
		public void setBK_TP_IND(String bK_TP_IND) {
			BK_TP_IND = bK_TP_IND;
		}
		public String getCURCY_3_CODE() {
			return CURCY_3_CODE;
		}
		public void setCURCY_3_CODE(String cURCY_3_CODE) {
			CURCY_3_CODE = cURCY_3_CODE;
		}
		public String getUNIT_NO() {
			return UNIT_NO;
		}
		public void setUNIT_NO(String uNIT_NO) {
			UNIT_NO = uNIT_NO;
		}
		public String getSECT_NO() {
			return SECT_NO;
		}
		public void setSECT_NO(String sECT_NO) {
			SECT_NO = sECT_NO;
		}
		public String getAC_6_NO() {
			return AC_6_NO;
		}
		public void setAC_6_NO(String aC_6_NO) {
			AC_6_NO = aC_6_NO;
		}
		public String getANSYS_CODE() {
			return ANSYS_CODE;
		}
		public void setANSYS_CODE(String aNSYS_CODE) {
			ANSYS_CODE = aNSYS_CODE;
		}
		public String getEFF_DTE() {
			return EFF_DTE;
		}
		public void setEFF_DTE(String eFF_DTE) {
			EFF_DTE = eFF_DTE;
		}
		public String getRSDT_TP_IND() {
			return RSDT_TP_IND;
		}
		public void setRSDT_TP_IND(String rSDT_TP_IND) {
			RSDT_TP_IND = rSDT_TP_IND;
		}
		public String getDR_CR_IND() {
			return DR_CR_IND;
		}
		public void setDR_CR_IND(String dR_CR_IND) {
			DR_CR_IND = dR_CR_IND;
		}
		public BigDecimal getPOST_AMT() {
			return POST_AMT;
		}
		public void setPOST_AMT(BigDecimal pOST_AMT) {
			POST_AMT = pOST_AMT;
		}
		public String getDTL_DESC() {
			return DTL_DESC;
		}
		public void setDTL_DESC(String dTL_DESC) {
			DTL_DESC = dTL_DESC;
		}
		public String getTRN_3_CODE() {
			return TRN_3_CODE;
		}
		public void setTRN_3_CODE(String tRN_3_CODE) {
			TRN_3_CODE = tRN_3_CODE;
		}
		public String getREF_NO() {
			return REF_NO;
		}
		public void setREF_NO(String rEF_NO) {
			REF_NO = rEF_NO;
		}
		public String getDTL_FILR() {
			return DTL_FILR;
		}
		public void setDTL_FILR(String dTL_FILR) {
			DTL_FILR = dTL_FILR;
		}
		public String getAPPLN_CODE() {
			return APPLN_CODE;
		}
		public void setAPPLN_CODE(String aPPLN_CODE) {
			APPLN_CODE = aPPLN_CODE;
		}
}


