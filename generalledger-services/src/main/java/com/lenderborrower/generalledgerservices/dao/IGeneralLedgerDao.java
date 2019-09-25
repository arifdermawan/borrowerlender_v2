package com.lenderborrower.generalledgerservices.dao;

import java.util.List;

import com.lenderborrower.generalledgerservices.model.JurnalGl;

public interface IGeneralLedgerDao {
	void createGeneralLedger(JurnalGl jurnal);
	Double getBalance(Integer idAkun);
	List<JurnalGl> getListGeneralLedger(Integer idAkun);
}
