package com.tencent.mm.plugin.nfc.d;

import com.tencent.smtt.sdk.WebView;

public final class a {
    private static final char[] lFr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static byte[] b(short s) {
        return new byte[]{(byte) ((s >>> 8) & WebView.NORMAL_MODE_ALPHA), (byte) (s & WebView.NORMAL_MODE_ALPHA)};
    }

    public static String byteArrayToHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & WebView.NORMAL_MODE_ALPHA;
            cArr[i * 2] = lFr[i2 >>> 4];
            cArr[(i * 2) + 1] = lFr[i2 & 15];
        }
        return new String(cArr);
    }

    public static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
