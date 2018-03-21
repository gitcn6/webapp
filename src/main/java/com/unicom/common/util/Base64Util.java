package com.unicom.common.util;

import java.util.UUID;

import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class Base64Util {
	public static void main(String[] args) throws Exception {
		/*String str = "inspur";
		BASE64Encoder base = new BASE64Encoder();
		String token = UUID.randomUUID().toString();
		System.out.println(token.replaceAll("-", ""));*/
		
		RandomNumberGenerator random = new SecureRandomNumberGenerator();
		String salt = random.nextBytes().toHex();
		System.out.println(salt);
		System.out.println(salt.length());
		String password =  new SimpleHash("md5", "123456", salt, 1).toHex();
		String password1 = new SimpleHash("md5", "123456").toHex();
		System.out.println(password1);
		String hex = new Md5Hash("123456").toHex();
		System.out.println(hex);
		AesCipherService aes = new AesCipherService();
		aes.setKeySize(128);
		ByteSource bs = aes.encrypt("你好".getBytes("utf-8"), aes.generateNewKey().getEncoded());
		System.out.println(bs.toHex());
	}
}
