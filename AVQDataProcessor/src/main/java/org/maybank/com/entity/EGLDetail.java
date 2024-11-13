package org.maybank.com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_EGL_UP_DOWN_DTL_MAPPING")
public class EGLDetail {
	@Id
	@Column(name = "FIELD_ORDER")
	private Integer FIELD_ORDER;

	public Integer getFIELD_ORDER() {
		return FIELD_ORDER;
	}

	public void setFIELD_ORDER(Integer fIELD_ORDER) {
		FIELD_ORDER = fIELD_ORDER;
	}

	public String getSYSTEM_ID() {
		return SYSTEM_ID;
	}

	public void setSYSTEM_ID(String sYSTEM_ID) {
		SYSTEM_ID = sYSTEM_ID;
	}

	public String getFILE_TYPE() {
		return FILE_TYPE;
	}

	public void setFILE_TYPE(String fILE_TYPE) {
		FILE_TYPE = fILE_TYPE;
	}

	public String getFIELD_NAME() {
		return FIELD_NAME;
	}

	public void setFIELD_NAME(String fIELD_NAME) {
		FIELD_NAME = fIELD_NAME;
	}

	@Column(name = "SYSTEM_ID")
	private String SYSTEM_ID;

	@Override
	public String toString() {
		return "EGLDetail [FIELD_ORDER=" + FIELD_ORDER + ", SYSTEM_ID=" + SYSTEM_ID + ", FILE_TYPE=" + FILE_TYPE
				+ ", FIELD_NAME=" + FIELD_NAME + "]";
	}

	@Column(name = "FILE_TYPE")
	private String FILE_TYPE;

	@Column(name = "FIELD_NAME")
	private String FIELD_NAME;
}
