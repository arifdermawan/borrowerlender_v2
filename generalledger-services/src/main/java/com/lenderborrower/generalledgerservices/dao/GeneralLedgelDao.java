package com.lenderborrower.generalledgerservices.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.lenderborrower.generalledgerservices.model.JurnalGl;

@Repository
public class GeneralLedgelDao implements IGeneralLedgerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void createGeneralLedger(JurnalGl jurnal) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO cool_db.jurnal_gl\n" + 
				"(tanggal, tipe_jurnal, jumlah, id_akun, nomor_transaksi, id_member, created_at)\n" + 
				"VALUES(CURDATE(), ?, ?, ?, ?, ?, CURDATE())";
		jdbcTemplate.update(sql, jurnal.getTipeJurnal(), jurnal.getJumlah(), jurnal.getIdAkun(), jurnal.getNomorTransaksi(), jurnal.getIdMember());
	}

	@Override
	public Double getBalance(Integer idAkun) {
		// TODO Auto-generated method stub
		String sql = "select sum(jumlah) where id_akun = ?";
		Double res = jdbcTemplate.queryForObject(sql,Double.class, idAkun);	
		return res;
	}

	@Override
	public List<JurnalGl> getListGeneralLedger(Integer kodeAkun) {
		// TODO Auto-generated method stub
		try {
		String sql = "SELECT id, tanggal, tipe_jurnal, jumlah, id_akun, nomor_transaksi, id_member, created_at, updated_at\n" + 
				"FROM cool_db.jurnal_gl where id_akun = ? order by tanggal desc";
		RowMapper<JurnalGl> rowMapper = new GeneralLedgerRowMapper();
		return this.jdbcTemplate.query(sql,rowMapper,kodeAkun);
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
