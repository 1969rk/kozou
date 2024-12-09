package tool;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

import bean.Password;
import dao.SecurityDAO;

public class Hash {
	
	public Password registHash(String password) throws Exception {
		
		byte[] salt = new byte[16];
		SecureRandom random = new SecureRandom();
		random.nextBytes(salt);
		String storeSalt = Base64.getEncoder().encodeToString(salt);
		
		String pepper = "koZou";
		
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(salt);
		md.update(pepper.getBytes());
		md.update(password.getBytes());
		byte[] hashBytes = md.digest();
		String hashWord = Base64.getEncoder().encodeToString(hashBytes);
		
		Password pw = new Password();
		pw.setPassword(password);
		pw.setHashWord(hashWord);
		pw.setSalt(storeSalt);
		
		return pw;
	}
	
	
	public String loginHash(int userId, String password) throws Exception {
		
		SecurityDAO dao1 = new SecurityDAO();
		String storedSalt = dao1.extractSalt(userId);
		byte[] salt = Base64.getDecoder().decode(storedSalt);
		
		String pepper = "koZou";
		
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(salt);
		md.update(pepper.getBytes());
		md.update(password.getBytes());
		
		byte[] hashButes = md.digest();
		String hashWord = Base64.getEncoder().encodeToString(hashButes);
		
		return hashWord;
	}
}
