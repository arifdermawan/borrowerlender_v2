package com.lenderborrower.generalledgerservices.services;

import java.util.List;

import com.lenderborrower.generalledgerservices.model.JurnalGl;
import com.lenderborrower.generalledgerservices.request.GeneralLedgerRequest;

public interface IGeneralLedgerServices {
	String addGeneralLedger(GeneralLedgerRequest request);
	Double getBalance(Integer idAkun);
	List<JurnalGl> getListJurnalGLByIdAkun(Integer idAkun);
}
