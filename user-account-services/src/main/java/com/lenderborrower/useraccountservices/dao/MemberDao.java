package com.lenderborrower.useraccountservices.dao;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lenderborrower.useraccountservices.dao.IMemberDao;
import com.lenderborrower.useraccountservices.dao.MemberRowMapper;
import com.lenderborrower.useraccountservices.model.Member;

@Transactional
@Repository
public class MemberDao implements IMemberDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		String sql  = "SELECT id, kode, nik, nama, phone_no, alamat, is_active, is_lender, is_borrower,created_at, updated_at FROM cool_db.members";
		//RowMapper<Member> rowMapper = new BeanPropertyRowMapper<Member>(Member.class);
		RowMapper<Member> rowMapper = new MemberRowMapper();
		return this.jdbcTemplate.query(sql,rowMapper);
	}

	@Override
	public Member getMember(Integer id) {
		// TODO Auto-generated method stub
		try {
		String sql  = "SELECT id, kode, nik, nama, phone_no, alamat, is_active, is_lender, is_borrower,created_at, updated_at FROM cool_db.members where id = ?";
			RowMapper<Member> rowMapper = new MemberRowMapper();
			return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Member getMemberByKode(String kode) {
		// TODO Auto-generated method stub
		try {
			String sql  = "SELECT id, kode, nik, nama, phone_no, alamat, is_active, is_lender, is_borrower,created_at, updated_at FROM cool_db.members where kode = ?";
			RowMapper<Member> rowMapper = new MemberRowMapper();
			return this.jdbcTemplate.queryForObject(sql,rowMapper,kode);
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addMember(Member member) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO cool_db.members\n" + 
				"(kode, nik, nama, phone_no, alamat, is_active, is_lender, is_borrower, created_at)\n" + 
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, CURDATE())";
		jdbcTemplate.update(sql,member.getKode(), member.getNik(), member.getNama(),member.getPhoneNo(),member.getAlamat(), member.getIsActive(), member.getIsLender(), member.getIsBorrower());
	}

	@Override
	public void updateMember(Member member) {
		// TODO Auto-generated method stub
		String sql = "UPDATE cool_db.members\n" + 
				"SET nik=?, nama=?, phone_no=?, alamat=?, is_active=?, is_lender=?, is_borrower=?, updated_at= CURDATE() \n" + 
				"WHERE id=?";
		jdbcTemplate.update(sql, member.getNik(), member.getNama(),member.getPhoneNo(),member.getAlamat(), member.getIsActive(), member.getIsLender(), member.getIsBorrower(), member.getId());
	}

	@Override
	public void updateMemberIsActive(Integer id, Integer isActive) {
		// TODO Auto-generated method stub
		String sql = "UPDATE cool_db.members\n" + 
				"SET is_active=?,updated_at= CURDATE() \n" + 
				"WHERE id=?";
		jdbcTemplate.update(sql,isActive, id);
	
	}

	@Override
	public Integer getCountMemberById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select count(id) from cool_db.members where id = ?";
		Integer res = jdbcTemplate.queryForObject(sql,Integer.class, id);
		return res;
	}

	@Override
	public Integer getCountMemberByIdAnActive(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select count(id) from cool_db.members where id = ? and is_active = 1";
		Integer res = jdbcTemplate.queryForObject(sql,Integer.class, id);
		return res;
	}

	

}
