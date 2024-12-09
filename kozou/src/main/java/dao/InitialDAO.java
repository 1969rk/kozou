package dao;

import java.sql.Connection;
import java.sql.Statement;

public class InitialDAO extends DAO {
	
	public void initialize() throws Exception {
		
		Connection con = getConnection();
		Statement cs = con.createStatement();
		
		cs.executeUpdate("CREATE SCHEMA IF NOT EXISTS "
				+ "public AUTHORIZATION postgres;");
		cs.executeUpdate("CREATE TABLE IF NOT EXISTS public.user_db "
				+ "(id serial, name character varying(32) NOT NULL, "
				+ "login_id character varying(16) NOT NULL UNIQUE, "
				+ "password character varying(128) NOT NULL, "
				+ "salt character varying(64) NOT NULL, "
				+ "CONSTRAINT user_db_pkey PRIMARY KEY (id));");

		
		
		
		
		
		cs.close();
		con.close();
		
	}
	

}


