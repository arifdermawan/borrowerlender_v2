package com.lenderborrower.useraccountservices.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lenderborrower.useraccountservices.dao.IMemberDao;
import com.lenderborrower.useraccountservices.error.NotFoundException;
import com.lenderborrower.useraccountservices.model.Member;
import com.lenderborrower.useraccountservices.request.MemberRequest;
import com.lenderborrower.useraccountservices.utils.Utility;

@Service
public class MemberServices  implements IMemberServices{
	
	@Autowired
	private IMemberDao memberDao;

	@Override
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		List<Member> listMember = memberDao.getAllMembers();
		return listMember;
	}

	@Override
	public Member getMemberById(Integer id) {
		// TODO Auto-generated method stub
		Member member = memberDao.getMember(id);
		if (member == null) {
			throw new NotFoundException("Member id : " + id);
		}
		return member;
	}

	@Override
	public Member getMemberByKode(String kode) {
		// TODO Auto-generated method stub
		Member member = memberDao.getMemberByKode(kode);
		if (member == null) {
			throw new NotFoundException("Member kode : " + kode);
		}
		return member;
	}

	@Override
	public String addMember(MemberRequest memberRequest) {
		// TODO Auto-generated method stub
		String kodeMember = Utility.randomAlphaNumeric(7);
		Member member = new Member(0, kodeMember, memberRequest.getNik(), memberRequest.getNama(), memberRequest.getPhoneNo(), memberRequest.getAlamat(), 1, memberRequest.getIsLender(), memberRequest.getIsBorrower(), null, null);
		memberDao.addMember(member);
		return kodeMember;
	}

	@Override
	public String updateMember(MemberRequest memberRequest) {
		// TODO Auto-generated method stub
		Integer getCount = memberDao.getCountMemberById(memberRequest.getId());
		if (getCount == 1) {
			Member member = new Member(memberRequest.getId(), memberRequest.getKode(), memberRequest.getNik(), memberRequest.getNama(), memberRequest.getPhoneNo(), memberRequest.getAlamat(), 1, memberRequest.getIsLender(), memberRequest.getIsBorrower(), null, null);
			memberDao.updateMember(member);
			return memberRequest.getId().toString();
		}else {
			throw new NotFoundException("Member id : " + memberRequest.getId());
		}
		
	}

	@Override
	public String updateIsActiveMember(Integer id, Integer isActive) {
		// TODO Auto-generated method stub
		Integer getCount = memberDao.getCountMemberById(id);
		if (getCount == 1) {
			memberDao.updateMemberIsActive(id, isActive);
			return id.toString();
		}else {
			throw new NotFoundException("Member id : " + id);
		}
	}

}
