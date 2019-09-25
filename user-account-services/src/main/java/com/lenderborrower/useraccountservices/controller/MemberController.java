package com.lenderborrower.useraccountservices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lenderborrower.useraccountservices.services.IMemberServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.lenderborrower.useraccountservices.model.*;
import com.lenderborrower.useraccountservices.request.MemberRequest;
import com.lenderborrower.useraccountservices.response.AccountResponse;
import com.lenderborrower.useraccountservices.response.MemberResponse;

@Controller
@RequestMapping("api/v1/")
@Api(value = "User Services", description = "User Service")
public class MemberController {
	
	@Autowired 
	private IMemberServices memberServices; 
	
	private MemberResponse response = null;
	
	@ApiOperation(value = "Get All Members", response = MemberResponse.class)
	@GetMapping("members")
	public ResponseEntity<MemberResponse> getAllMembers() {
		List<Member> listMember = memberServices.getAllMembers();
		response = new MemberResponse(HttpStatus.OK.value(), "List Members", listMember, null);
		return new ResponseEntity<MemberResponse>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Member By id", response = MemberResponse.class)
	@GetMapping("member/{id}")
	public ResponseEntity<MemberResponse> getMemberById(@PathVariable Integer id) {
		Member member = memberServices.getMemberById(id);
		response = new MemberResponse(HttpStatus.OK.value(), "Member : " + member.getId(), null, member);
		return new ResponseEntity<MemberResponse>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Check Member By id active or not", response = MemberResponse.class)
	@GetMapping("member/{id}/isactive")
	public ResponseEntity<Integer> checkMemberActive(@PathVariable Integer id) {
		Integer res = memberServices.getCountMemberByIdAnActive(id);
		return new ResponseEntity<Integer>(res, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Member by kode ", response = MemberResponse.class)
	@GetMapping("member")
	public ResponseEntity<MemberResponse> getMemberbyKode(@RequestParam(name = "kode") String kode){
		Member member = memberServices.getMemberByKode(kode);
		response = new MemberResponse(HttpStatus.OK.value(), "Member : " + member.getId(), null, member);
		return new ResponseEntity<MemberResponse>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add Member ", response = MemberResponse.class)
	@PostMapping("member")
	public ResponseEntity<MemberResponse> addMember (
			@ApiParam(value = "Member object store in database table", required = true) @Valid @RequestBody MemberRequest member){
			String kodeMember = memberServices.addMember(member);
			response = new MemberResponse(HttpStatus.CREATED.value(), "Sukses Kode Member = " + kodeMember, null, null);
			return new ResponseEntity<MemberResponse>(response, HttpStatus.CREATED);	
	}
	
	@ApiOperation(value = "Update Member ", response = MemberResponse.class)
	@PutMapping("member")
	public ResponseEntity<MemberResponse> updateMember (
			@ApiParam(value = "Member object store in database table", required = true) @Valid @RequestBody MemberRequest member){
			String kode = memberServices.updateMember(member);
			response = new MemberResponse(HttpStatus.OK.value(), "Sukse UpdateMember = " + member.getId().toString(), null, null);
			return new ResponseEntity<MemberResponse>(response, HttpStatus.OK);		
	}
	
	@ApiOperation(value = "Update Account, Set Active ot not Active Member", response = MemberResponse.class)
	@PatchMapping("member/{id}")
	public ResponseEntity<MemberResponse> updateMember (
			@PathVariable Integer id,
			@RequestParam(name = "isActive") Integer isActive){
		String kode = memberServices.updateIsActiveMember(id, isActive);
		response = new MemberResponse(HttpStatus.OK.value(), "Sukse Update Member = " + id.toString(), null, null);
		return new ResponseEntity<MemberResponse>(response, HttpStatus.OK);
		
	}
}
