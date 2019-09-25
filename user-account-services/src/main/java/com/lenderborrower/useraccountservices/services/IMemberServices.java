package com.lenderborrower.useraccountservices.services;

import java.util.List;

import com.lenderborrower.useraccountservices.model.Member;
import com.lenderborrower.useraccountservices.request.MemberRequest;

public interface IMemberServices {
	List<Member> getAllMembers();
	Member getMemberById(Integer id);
	Member getMemberByKode(String kode);
	String addMember(MemberRequest member);
	String updateMember(MemberRequest member);
	String updateIsActiveMember(Integer id, Integer isActive);
}
