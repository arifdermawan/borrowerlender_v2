package com.lenderborrower.generalledgerservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import com.lenderborrower.generalledgerservices.config.ConfigProperties;;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class GeneralledgerServicesApplication implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(GeneralledgerServicesApplication.class);

	
	 @Autowired
	 JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(GeneralledgerServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 log.info("StartApplication...");
		 log.info("Create tables...");
		 
		jdbcTemplate.execute("\n" + 
				"CREATE TABLE IF NOT EXISTS `jurnal_gl` (\n" + 
				"  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" + 
				"  `tanggal` datetime NOT NULL,\n" + 
				"  `tipe_jurnal` int(11) NOT NULL,\n" + 
				"  `jumlah` double NOT NULL,\n" + 
				"  `id_akun` bigint(20) NOT NULL,\n" + 
				"  `nomor_transaksi` varchar(100) NOT NULL,\n" + 
				"  `id_member` bigint(20) NOT NULL,\n" + 
				"  `created_at` datetime DEFAULT NULL,\n" + 
				"  `updated_at` datetime DEFAULT NULL,\n" + 
				"  PRIMARY KEY (`id`),\n" + 
				"  KEY `jurnal_gl_FK` (`id_akun`)\n" + 
				") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1");
		
		 log.info("End Create");
	}

}
