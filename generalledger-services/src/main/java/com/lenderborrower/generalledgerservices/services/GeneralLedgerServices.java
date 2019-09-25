package com.lenderborrower.generalledgerservices.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.lenderborrower.generalledgerservices.config.ConfigProperties;
import com.lenderborrower.generalledgerservices.dao.IGeneralLedgerDao;
import com.lenderborrower.generalledgerservices.error.NotFoundException;
import com.lenderborrower.generalledgerservices.model.JurnalGl;
import com.lenderborrower.generalledgerservices.request.GeneralLedgerRequest;

@Service
public class GeneralLedgerServices implements IGeneralLedgerServices {

	@Autowired
	private IGeneralLedgerDao generalDao;
	
	 @Autowired
	 private ConfigProperties appProperties;
	 
	@Override
	public String addGeneralLedger(GeneralLedgerRequest request) {
		// TODO Auto-generated method stub
		
		String urlAccount = appProperties.getUrlaccount();
		String urlMember = appProperties.getUrlmember();
		
		Map<String, Integer> params = new HashMap<String,Integer>();
	    params.put("id", request.getIdAkun());
	    params.put("idMember", request.getIdMember());
	    Integer res = exchangeUrl(urlAccount, params);
	    if (res == 0) {
	    	throw new NotFoundException("Account id : " + request.getIdMember());
	    }
	    
	    params = new HashMap<String,Integer>();
	    params.put("id", request.getIdAkun());
	    res = exchangeUrl(urlMember, params);
	    if (res == 0) {
	    	throw new NotFoundException("Member id : " + request.getIdMember());
	    }
	    String kodeTransaksi = UUID.randomUUID().toString();
	    JurnalGl jurnal = new JurnalGl(1, null, null, request.getJumlah(), null, request.getTipeJurnal(), request.getIdAkun(), kodeTransaksi, request.getIdMember());
	    generalDao.createGeneralLedger(jurnal);
	    
		return "";
	}

	private Integer exchangeUrl(String urlAccount, Map<String, Integer> params) {
		RestTemplate restTemplate = new RestTemplate();
	    Integer res = restTemplate.getForObject(urlAccount, Integer.class,params);
		return res;
	}

	@Override
	public Double getBalance(Integer idAkun) {
		// TODO Auto-generated method stub
		return generalDao.getBalance(idAkun);
	}

	@Override
	public List<JurnalGl> getListJurnalGLByIdAkun(Integer idAkun) {
		// TODO Auto-generated method stub
		List<JurnalGl> list = generalDao.getListGeneralLedger(idAkun);
		return list;
	}

}
