package team.t.t.dto;

import java.sql.Date;

public class CommDTO {
	private int COMM_NO;
	private String MEM_ID;
	private Date COMM_DATE;
	private String COMM_CONT;
	private int CBOAR_NO;
	
	public int getCOMM_NO() {
		return COMM_NO;
	}
	public void setCOMM_NO(int cOMM_NO) {
		COMM_NO = cOMM_NO;
	}
	public String getMEM_ID() {
		return MEM_ID;
	}
	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}
	public Date getCOMM_DATE() {
		return COMM_DATE;
	}
	public void setCOMM_DATE(Date cOMM_DATE) {
		COMM_DATE = cOMM_DATE;
	}
	public String getCOMM_CONT() {
		return COMM_CONT;
	}
	public void setCOMM_CONT(String cOMM_CONT) {
		COMM_CONT = cOMM_CONT;
	}
	
	public int getCBOAR_NO() {
		return CBOAR_NO;
	}
	public void setCBOAR_NO(int cBOAR_NO) {
		CBOAR_NO = cBOAR_NO;
	}
	
	
	
}
