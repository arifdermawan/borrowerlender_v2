package com.lenderborrower.generalledgerservices.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.lenderborrower.generalledgerservices.model.JurnalGl;


public class GeneralLedgerRowMapper implements RowMapper<JurnalGl>{

	@Override
	public JurnalGl mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		JurnalGl member =  new JurnalGl(rs.getInt("id"), rs.getDate("created_at"), rs.getDate("created_at"), rs.getDouble("jumlah"), rs.getDate("tanggal"), rs.getInt("tipe_jurnal"), rs.getInt("id_akun"), rs.getString("nomor_transaksi"), rs.getInt("id_member"));
		return member;
	}

}
