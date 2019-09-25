package com.lenderborrower.useraccountservices.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lenderborrower.useraccountservices.model.Account;
import com.lenderborrower.useraccountservices.model.Member;

public class AccountRowMapper implements RowMapper<Account>{

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Account account = new Account(rs.getInt("id"), rs.getDate("created_at"),rs.getDate("updated_at"), rs.getString("kode_akun"), rs.getInt("is_active"), rs.getInt("id_member"));
		return account;
	}

}
