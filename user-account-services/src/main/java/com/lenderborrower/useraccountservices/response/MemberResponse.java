package com.lenderborrower.useraccountservices.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lenderborrower.useraccountservices.model.Member;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class MemberResponse extends BaseResponse {
	List<Member> members;
	Member member;
	public MemberResponse(Integer httpCode, String message, List<Member> members, Member member) {
		super(httpCode, message);
		this.members = members;
		this.member = member;
	}
	public List<Member> getMembers() {
		return members;
	}
	public Member getMember() {
		return member;
	}
}
