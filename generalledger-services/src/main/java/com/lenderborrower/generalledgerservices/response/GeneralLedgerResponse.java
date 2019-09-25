package com.lenderborrower.generalledgerservices.response;

import java.util.List;
import com.lenderborrower.generalledgerservices.model.JurnalGl;

public class GeneralLedgerResponse extends BaseResponse{
	private JurnalGl jurnalGL;
	private List<JurnalGl> listJurnalGL;
	public GeneralLedgerResponse(Integer httpCode, String message, JurnalGl jurnalGL, List<JurnalGl> listJurnalGL) {
		super(httpCode, message);
		this.jurnalGL = jurnalGL;
		this.listJurnalGL = listJurnalGL;
	}
	public JurnalGl getJurnalGL() {
		return jurnalGL;
	}
	public List<JurnalGl> getListJurnalGL() {
		return listJurnalGL;
	}
	
	
	
	
}
