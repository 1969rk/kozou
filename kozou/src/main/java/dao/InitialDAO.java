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
				+ "salt character varying(64) NOT NULL, PRIMARY KEY (id));");

		cs.executeUpdate("INSERT INTO public.user_db (name, login_id, password, salt) "
				+ "SELECT '管理者', 'root', 'UQhdPPKpRQxzu4syHA841n+rotdwvCbo3eZiEXOFGP0CQ6KLTn4Pzj7PqLbclQps2Cvbf3Dv2iC06p0cBt5XRA==', "
				+ "'BGrRr9rH1YqMUWYOqh4EEg==' WHERE NOT EXISTS "
				+ "(SELECT login_id FROM public.user_db WHERE login_id = 'root');");
		
		
		
		
		
		cs.close();
		con.close();
		
	}
	

}


