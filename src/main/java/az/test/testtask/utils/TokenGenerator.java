package az.test.testtask.utils;

import java.security.SecureRandom;

public class TokenGenerator {

    protected static SecureRandom random = new SecureRandom();

    public static synchronized String generateToken() {
        long longToken = Math.abs(random.nextLong());
        return Long.toString(longToken, 16);
    }

    public static synchronized String generateToken(int length) {
        long longToken = Math.abs(random.nextLong());
        return Long.toString(longToken, length);
    }

}
