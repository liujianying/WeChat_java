package com.tencent.matrix.resource.a.a;

import java.security.MessageDigest;

public final class a {
    private static final char[] aca = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String t(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                if (b < (byte) 0 || b > (byte) 15) {
                    stringBuilder.append(aca[(b >> 4) & 15]).append(aca[b & 15]);
                } else {
                    stringBuilder.append('0').append(aca[b]);
                }
            }
            return stringBuilder.toString();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
