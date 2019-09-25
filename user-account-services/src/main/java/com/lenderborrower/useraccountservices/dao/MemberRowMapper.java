package com.lenderborrower.useraccountservices.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lenderborrower.useraccountservices.model.Member;

public class MemberRowMapper implements RowMapper<Member>{

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Member member =  new Member(rs.getInt("id"), rs.getString("kode"), rs.getString("nik"), rs.getString("nama"), rs.getString("phone_no"), rs.getString("alamat"), rs.getInt("is_active"), rs.getInt("is_lender"), rs.getInt("is_borrower"), rs.getDate("created_at"),rs.getDate("updated_at"));
		return member;
	}

}
