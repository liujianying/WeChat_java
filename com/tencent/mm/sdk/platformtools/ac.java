package com.tencent.mm.sdk.platformtools;

import java.security.MessageDigest;

public final class ac {
    protected static char[] buX = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static ThreadLocal<MessageDigest> sGw = new ThreadLocal<MessageDigest>() {
        private static MessageDigest tK() {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (Throwable e) {
                throw new RuntimeException("Initialize MD5 failed.", e);
            }
        }
    };

    public static String ce(String str) {
        return t(str.getBytes());
    }

    public static String t(byte[] bArr) {
        byte[] digest = ((MessageDigest) sGw.get()).digest(bArr);
        int length = digest.length;
        StringBuffer stringBuffer = new StringBuffer(length * 2);
        int i = length + 0;
        for (length = 0; length < i; length++) {
            byte b = digest[length];
            char c = buX[(b & 240) >> 4];
            char c2 = buX[b & 15];
            stringBuffer.append(c);
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }
}
