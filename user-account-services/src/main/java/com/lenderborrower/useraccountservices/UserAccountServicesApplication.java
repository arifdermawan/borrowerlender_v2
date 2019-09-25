package com.lenderborrower.useraccountservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class UserAccountServicesApplication implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UserAccountServicesApplication.class);

	 @Autowired
	 JdbcTemplate jdbcTemplate;
	 
	public static void main(String[] args) {
		SpringApplication.run(UserAccountServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		 log.info("StartApplication...");
		 log.info("Create tables...");
		 
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS `members` (\n" + 
				"  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" + 
				"  `kode` varchar(100) NOT NULL,\n" + 
				"  `nik` varchar(16) NOT NULL,\n" + 
				"  `nama` varchar(200) NOT NULL,\n" + 
				"  `phone_no` varchar(100) NOT NULL,\n" + 
				"  `alamat` varchar(200) DEFAULT NULL,\n" + 
				"  `is_active` tinyint(1) NOT NULL DEFAULT '0',\n" + 
				"  `is_lender` tinyint(1) NOT NULL DEFAULT '0',\n" + 
				"  `is_borrower` tinyint(1) NOT NULL,\n" + 
				"  `created_at` datetime DEFAULT NULL,\n" + 
				"  `updated_at` datetime DEFAULT NULL,\n" + 
				"  PRIMARY KEY (`id`)\n" + 
				") ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1");
		
		
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS `account` (\n" + 
				"  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" + 
				"  `kode_akun` varchar(10) NOT NULL,\n" + 
				"  `is_active` tinyint(1) NOT NULL,\n" + 
				"  `id_member` bigint(20) NOT NULL,\n" + 
				"  `created_at` datetime DEFAULT NULL,\n" + 
				"  `updated_at` datetime DEFAULT NULL,\n" + 
				"  PRIMARY KEY (`id`),\n" + 
				"  KEY `account_FK` (`id_member`),\n" + 
				"  CONSTRAINT `account_FK` FOREIGN KEY (`id_member`) REFERENCES `members` (`id`) ON DELETE CASCADE ON UPDATE CASCADE\n" + 
				") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1");
		
		log.info("Done");
	
	}

}
