package com.lenderborrower.useraccountservices.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lenderborrower.useraccountservices.model.Account;
import com.lenderborrower.useraccountservices.model.Member;

@Repository
public class AccountDao implements IAccountDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		String sql = "SELECT id, kode_akun, is_active, id_member, created_at, updated_at\n" + 
				"FROM cool_db.account";
		RowMapper<Account> rowMapper = new AccountRowMapper();
		return this.jdbcTemplate.query(sql,rowMapper);
	}

	@Override
	public List<Account> getListAccountByMemberId(Integer id) {
		// TODO Auto-generated method stub
		String sql = "SELECT id, kode_akun, is_active, id_member, created_at, updated_at\n" + 
				"FROM cool_db.account where id_member = ?";
		RowMapper<Account> rowMapper = new AccountRowMapper();
		return this.jdbcTemplate.query(sql,rowMapper, id);
	}

	@Override
	public Account getAccount(Integer accountId) {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT id, kode_akun, is_active, id_member, created_at, updated_at\n" + 
					"FROM cool_db.account where id = ?";
			RowMapper<Account> rowMapper = new AccountRowMapper();
			return this.jdbcTemplate.queryForObject(sql,rowMapper,accountId);
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void createAccount(Account acccount) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO cool_db.account\n" + 
				"(kode_akun, is_active, id_member, created_at)\n" + 
				"VALUES(?, ?, ?,CURDATE())";
		
		jdbcTemplate.update(sql, acccount.getKodeAkun(),1,acccount.getIdMember());
	}

	@Override
	public void updateAccount(Integer id, Integer isActive) {
		// TODO Auto-generated method stub
		String sql = "UPDATE cool_db.account\n" + 
				"SET is_active=?, updated_at=CURRDATE()\n" + 
				"WHERE id=?";
		jdbcTemplate.update(sql, isActive, id);
	}

	@Override
	public Integer getCountAccountById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select count(id) from cool_db.account where id = ?";
		Integer res = jdbcTemplate.queryForObject(sql,Integer.class, id);
		return res;
	}

}
