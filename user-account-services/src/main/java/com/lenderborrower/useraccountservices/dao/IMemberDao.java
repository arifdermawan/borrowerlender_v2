package com.lenderborrower.useraccountservices.dao;

import java.util.List;

import com.lenderborrower.useraccountservices.model.Member;

public interface IMemberDao {
	List<Member> getAllMembers();
	Member getMember(Integer id);
	Member getMemberByKode(String kode);
	void addMember(Member member);
	void updateMember(Member member);
	void updateMemberIsActive(Integer id, Integer isActive);
	Integer getCountMemberById(Integer id);
	Integer getCountMemberByIdAnActive(Integer id);
}
