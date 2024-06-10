package kp.cmsc.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SecurityUtil {

private static final String ALGORITHM = "AES";

public String getSalt() {

        //1. Random, byte 객체 생성
        SecureRandom  r = new SecureRandom ();
        byte[] salt = new byte[20];

        //2. 난수 생성
        r.nextBytes(salt);

        //3. byte To String (10진수의 문자열로 변경)
        StringBuffer sb = new StringBuffer();
        for(byte b : salt) {
            sb.append(String.format("%02x", b));
        };

        return sb.toString();
    }

    public String getEncrypt(String pwd, String salt) {

        String result = "";
        try {
            //1. SHA256 알고리즘 객체 생성
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            //2. pwd와 salt 합친 문자열에 SHA 256 적용
//            System.out.println("pwd + salt 적용 전 : " + pwd+salt);
            md.update((pwd+salt).getBytes());
            byte[] pwdsalt = md.digest();

            //3. byte To String (10진수의 문자열로 변경)
            StringBuffer sb = new StringBuffer();
            for (byte b : pwdsalt) {
                sb.append(String.format("%02x", b));
            }

            result=sb.toString();
//            System.out.println("pwd + salt 적용 후 : " + result);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(256, new SecureRandom());
        return keyGen.generateKey();
    }

    public static SecretKey getKeyFromPassword(String password) throws Exception {
        byte[] keyBytes = password.getBytes();
        return new SecretKeySpec(keyBytes, 0, keyBytes.length, ALGORITHM);
    }

    public static void encryptFile(File inputFile, File outputFile, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);
            outputStream.write(outputBytes);
        }
    }

    public static void decryptFile(File inputFile, File outputFile, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);

        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);
            outputStream.write(outputBytes);
        }
    }

    /*
     * byte 배열을 Hex 값으로 변환
     */
    final static char[] hexArray = "0123456789abcdef".toCharArray();
    public static String bytesToHex1(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];

        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }

        return new String(hexChars);
    }


    /*
     * byte 배열을 Hex 값으로 변환
     */
    public static String bytesToHex2(byte[] bytes) {
        StringBuilder builder = new StringBuilder();

        for (byte b: bytes) {
            builder.append(String.format("%02x", b));
        }

        return builder.toString();
    }

    /*
     * byte 배열을 Hex 값으로 변환
     */
    public static String bytesToHex3(byte[] bytes) {
        String hexText = new java.math.BigInteger(bytes).toString(16);
        return hexText;
    }

    /**
     * 평문을 받아 MD5로 암호화 적용 후 Hex 값으로 인코딩
     * @param plainText
     * @return
     */
    public static String encryptToHex(String plainText) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return bytesToHex2(md.digest());
    }

    /**
     * 평문을 받아 MD5로 암호화 적용 후 Hex 값으로 인코딩
     * @param plainText
     * @return
     */
    public static String encryptToHex(String plainText, String Algorithms) throws Exception {
        MessageDigest md = null;
        md = MessageDigest.getInstance(Algorithms);
        md.update(plainText.getBytes("utf-8"));
        return bytesToHex2(md.digest());
    }

    /**
     * 평문을 받아 MD5로 암호화 적용 후 Base64 값으로 인코딩
     * @param plainText
     * @return
     */
    public static String encryptToBase64(String plainText, String Algorithms) throws Exception {
        MessageDigest md = null;
        md = MessageDigest.getInstance(Algorithms);
        md.update(plainText.getBytes());
        return Base64.getEncoder().encodeToString(md.digest());
    }

    /**
     * 평문을 받아 MD5로 암호화 적용 후 Base64 값으로 인코딩
     * @param plainText
     * @return
     */
    public static String encryptToBase64(String plainText) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return Base64.getEncoder().encodeToString(md.digest());
    }


    public static Key makeAESKey(String sKey) {
        final byte[] key = sKey.getBytes();
        return new SecretKeySpec(key, "AES");
    }

    public static byte[] aesEncode(byte[] src, Key skey) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            return cipher.doFinal(src);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] aesDecode(byte[] src, Key skey) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, skey);
            return cipher.doFinal(src);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] hexToByteArray(String hex) {
        if (hex == null || hex.length() == 0) {
            return null;
        }

        byte[] ba = new byte[hex.length() / 2];
        for (int i = 0; i < ba.length; i++) {
            ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return ba;
    }

    /**
     * 암호화하려는 문자열 데이터의 길이가 16배수가 아닐 경우 '&&' 구분자후에 '0'으로 채움.
     */
    public static String padding16(String strValue) {

        int iNum1 = strValue.length();
        int iNum2 = iNum1 % 16;

        if (iNum2 != 0) {
            strValue = strValue + "&&";
            int iNum3 = 14 - iNum2;
            for (int i = 0; i < iNum3; i++) {
                strValue = strValue + "0";
            }
        }

        return strValue;
    }

}
