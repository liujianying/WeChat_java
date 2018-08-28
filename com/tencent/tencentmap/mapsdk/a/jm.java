package com.tencent.tencentmap.mapsdk.a;

public class jm {
    public static byte[] a(int i) {
        return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    public static int a(byte[] bArr) {
        return (((bArr[0] & 255) | (65280 & (bArr[1] << 8))) | (16711680 & (bArr[2] << 16))) | (-16777216 & (bArr[3] << 24));
    }

    public static boolean b(byte[] bArr) {
        return bArr[0] > (byte) 0;
    }

    public static float c(byte[] bArr) {
        return Float.intBitsToFloat(a(bArr));
    }

    public static byte[] a(String str) {
        if (str != null) {
            try {
                return str.getBytes("UTF-16LE");
            } catch (Exception e) {
            }
        }
        return new byte[0];
    }

    public static String d(byte[] bArr) {
        try {
            return new String(bArr, "UTF-16LE").trim();
        } catch (Exception e) {
            return null;
        }
    }

    public static String a(byte[] bArr, String str) {
        try {
            return new String(bArr, str).trim();
        } catch (Exception e) {
            return null;
        }
    }
}
