package com.callor.readbook.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptEx_01 {

    public static void main(String[] args) {

        StandardPBEStringEncryptor pbe = new StandardPBEStringEncryptor();

        String name = "Korea";
        String salt = "!Biz1234";
        String encPolicy = "PBEWithMD5AndDES";

        pbe.setAlgorithm(encPolicy);
        pbe.setPassword(salt);

        String username = "root";
        String password = "!Biz12341234";

        String encUserName = pbe.encrypt(username);
        String encPassWord = pbe.encrypt(password);

        System.out.printf("user name : %s \n", encUserName);
        System.out.printf("password : %s \n", encPassWord);

        String encText = pbe.encrypt(name);
        System.out.println(encText);

        String planText = pbe.decrypt(encText);
        System.out.println(planText);
    }
}
