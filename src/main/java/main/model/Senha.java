package main.model;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Senha {
    private static int ITERACOES = 600_000;

    public static String geraHash(char[] senha) throws GeneralSecurityException {
        byte[] sal = new byte[16];
        new SecureRandom().nextBytes(sal);

        PBEKeySpec configuracao = new PBEKeySpec (senha, sal, ITERACOES, 256);
        try{
            SecretKeyFactory algoritmo = 
            SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = algoritmo.generateSecret(configuracao).getEncoded();

            Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(sal) + ":" + encoder.encodeToString(hash);
        }finally {
            configuracao.clearPassword();
        }
    }

}