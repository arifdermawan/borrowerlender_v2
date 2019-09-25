package com.lenderborrower.generalledgerservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lenderborrower.generalledgerservices.model.JurnalGl;
import com.lenderborrower.generalledgerservices.request.GeneralLedgerRequest;
import com.lenderborrower.generalledgerservices.response.GeneralLedgerResponse;
import com.lenderborrower.generalledgerservices.services.IGeneralLedgerServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("api/v1")
@Api(value = "General Ledger Services",description  = "General Ledger Services")
public class GeneralLedgerController {
	
	@Autowired
	private IGeneralLedgerServices services;
	
	private GeneralLedgerResponse response = null;

	
	@ApiOperation(value = "Add General Ledger", response = GeneralLedgerResponse.class)
	@PostMapping("gl")
	public ResponseEntity<GeneralLedgerResponse> addGeneralLedger(
			@ApiParam(value = "General Ledger Object", required = true) @RequestBody GeneralLedgerRequest generalLedger){
		String res = services.addGeneralLedger(generalLedger);	
		response = new GeneralLedgerResponse(HttpStatus.CREATED.value(),"General Ledger Created",null,null);
		return new ResponseEntity<GeneralLedgerResponse>(response, HttpStatus.CREATED);
		
	}
	
	@ApiOperation(value = "Get Balance", response = GeneralLedgerResponse.class)
	@GetMapping("gl/balance/{idAkun}")
	public ResponseEntity<Double> getBAlance(@PathVariable("idAkun") Integer idAkun){
		Double balance = services.getBalance(idAkun);
		return new ResponseEntity<Double>(balance,HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Get General Ledger By idAkun", response = GeneralLedgerResponse.class)
	@GetMapping("gl/{idAkun}")
	public ResponseEntity<GeneralLedgerResponse> getGlByKodeAkun(@PathVariable("idAkun") Integer idAkun){
		List<JurnalGl> listJurnalGL = services.getListJurnalGLByIdAkun(idAkun);
		response = new GeneralLedgerResponse(HttpStatus.OK.value(), "List GeneralLedger", null,listJurnalGL);
		return new ResponseEntity<GeneralLedgerResponse>(response,HttpStatus.OK);
		
	}
}
