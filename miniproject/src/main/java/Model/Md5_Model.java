package Model;

import java.security.MessageDigest;

import org.springframework.stereotype.Repository;

//회원 가입 , 로그인시 비밀번호 md5로 암호화.
public abstract class Md5_Model {
	 public String md5(String pw) throws Exception{
	        StringBuilder sb = new StringBuilder();
	        String md5_data = "";

	        MessageDigest md = MessageDigest.getInstance("md5");
	        md.update(pw.getBytes());
	        byte md5byte[] = md.digest();

	        for(byte alg : md5byte) {
	            sb.append(String.format("%01x", alg));
	        }
	        md5_data = String.valueOf(sb);

	        return md5_data;
	    }
}
