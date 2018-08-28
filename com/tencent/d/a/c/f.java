package com.tencent.d.a.c;

import java.security.MessageDigest;

public final class f {
    public static boolean oW(String str) {
        return str == null || str.length() <= 0;
    }

    public static String oV(String str) {
        return str == null ? "" : str;
    }

    public static long gU(long j) {
        return ((System.nanoTime() - j) / 1000) / 1000;
    }

    public static String u(byte[] bArr) {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                int i4 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
                i2 = i4;
            }
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }
}
