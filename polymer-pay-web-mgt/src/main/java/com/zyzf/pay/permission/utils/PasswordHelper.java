/*
 * Copyright 2015-2102 zyzf(http://) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zyzf.pay.permission.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.zyzf.pay.permission.entity.ZyppOperator;

/**
 * 生成密码工具类
 *
 * ：
 * 
 * 
 */
public class PasswordHelper {

	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	private static String algorithmName = "md5";

	private static String hashIteration = "2";

	private static int hashIterations = Integer.valueOf(hashIteration);

	public static void encryptPassword(ZyppOperator ZyppOperator) {

		ZyppOperator.setsalt(randomNumberGenerator.nextBytes().toHex());

		String newPassword = new SimpleHash(algorithmName, ZyppOperator.getLoginPwd(), ByteSource.Util.bytes(ZyppOperator.getCredentialsSalt()), hashIterations).toHex();

		ZyppOperator.setLoginPwd(newPassword);
	}

	/**
	 * 加密密码
	 * 
	 * @param loginPwd
	 *            明文密码
	 * @param salt
	 * @return
	 */
	public static String getPwd(String loginPwd, String salt) {
		String newPassword = new SimpleHash(algorithmName, loginPwd, ByteSource.Util.bytes(salt), hashIterations).toHex();
		return newPassword;
	}

}
