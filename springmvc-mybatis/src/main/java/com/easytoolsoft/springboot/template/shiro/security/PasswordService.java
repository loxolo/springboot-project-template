package com.easytoolsoft.springboot.template.shiro.security;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

/**
 * 用户口令服务类
 *
 * @author zhiwei.deng
 * @date 2017-03-25
 */
@Service("MemberPasswordService")
public class PasswordService {
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public String genreateSalt() {
        return randomNumberGenerator.nextBytes().toHex();
    }

    public String encryptPassword(String password, String credentialsSalt) {
        return new SimpleHash(
            algorithmName,
            password,
            ByteSource.Util.bytes(credentialsSalt),
            hashIterations).toHex();
    }
}