package com.tencent.c.f;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c {
    public static byte[] k() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            String str = "http://pmir.3g.qq.com";
            int[] iArr = new int[]{-36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49};
            for (int i = 0; i < str.length(); i++) {
                stringBuffer.append((char) (str.charAt(i) + iArr[i]));
            }
            return stringBuffer.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    private static void a(byte[] bArr, int[] iArr) {
        int i;
        int length = bArr.length >> 2;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            i = i2 + 1;
            iArr[i3] = bArr[i2] & 255;
            int i4 = i + 1;
            iArr[i3] = iArr[i3] | ((bArr[i] & 255) << 8);
            i = i4 + 1;
            iArr[i3] = iArr[i3] | ((bArr[i4] & 255) << 16);
            i2 = i + 1;
            iArr[i3] = ((bArr[i] & 255) << 24) | iArr[i3];
            i3++;
        }
        if (i2 < bArr.length) {
            i = i2 + 1;
            iArr[i3] = bArr[i2] & 255;
            i2 = 8;
            while (i < bArr.length) {
                iArr[i3] = iArr[i3] | ((bArr[i] & 255) << i2);
                i++;
                i2 += 8;
            }
        }
    }

    private static void a(int[] iArr, int i, byte[] bArr) {
        int i2;
        int length = bArr.length >> 2;
        if (length > i) {
            length = i;
        }
        int i3 = 0;
        int i4 = 0;
        while (i4 < length) {
            i2 = i3 + 1;
            bArr[i3] = (byte) (iArr[i4] & 255);
            i3 = i2 + 1;
            bArr[i2] = (byte) ((iArr[i4] >>> 8) & 255);
            i2 = i3 + 1;
            bArr[i3] = (byte) ((iArr[i4] >>> 16) & 255);
            i3 = i2 + 1;
            bArr[i2] = (byte) ((iArr[i4] >>> 24) & 255);
            i4++;
        }
        if (i > length && i3 < bArr.length) {
            length = i3 + 1;
            bArr[i3] = (byte) (iArr[i4] & 255);
            i3 = 8;
            while (true) {
                i2 = i3;
                if (i2 <= 24 && length < bArr.length) {
                    i3 = length + 1;
                    bArr[length] = (byte) ((iArr[i4] >>> i2) & 255);
                    i2 += 8;
                } else {
                    return;
                }
            }
        }
    }

    private static byte[] bN(byte[] bArr) {
        if (bArr == null || bArr.length <= 16) {
            return bArr;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static byte[] j(byte[] bArr, byte[] bArr2) {
        byte[] bN = bN(bArr2);
        if (bArr == null || bN == null || bArr.length == 0) {
            return bArr;
        }
        int i;
        int length = bArr.length % 4 == 0 ? (bArr.length >>> 2) + 1 : (bArr.length >>> 2) + 2;
        int[] iArr = new int[length];
        a(bArr, iArr);
        iArr[length - 1] = bArr.length;
        length = bN.length % 4 == 0 ? bN.length >>> 2 : (bN.length >>> 2) + 1;
        if (length < 4) {
            length = 4;
        }
        int[] iArr2 = new int[length];
        for (i = 0; i < length; i++) {
            iArr2[i] = 0;
        }
        a(bN, iArr2);
        int length2 = iArr.length - 1;
        i = iArr[length2];
        length = (52 / (length2 + 1)) + 6;
        int i2 = 0;
        while (true) {
            int i3 = i;
            i = length - 1;
            if (length > 0) {
                int i4;
                i2 -= 1640531527;
                int i5 = (i2 >>> 2) & 3;
                length = 0;
                while (length < length2) {
                    i4 = iArr[length + 1];
                    i3 = (((i3 ^ iArr2[(length & 3) ^ i5]) + (i4 ^ i2)) ^ (((i3 >>> 5) ^ (i4 << 2)) + ((i4 >>> 3) ^ (i3 << 4)))) + iArr[length];
                    iArr[length] = i3;
                    length++;
                }
                i4 = iArr[0];
                length = ((iArr2[(length & 3) ^ i5] ^ i3) + (i4 ^ i2)) ^ (((i3 >>> 5) ^ (i4 << 2)) + ((i4 >>> 3) ^ (i3 << 4)));
                iArr[length2] = iArr[length2] + length;
            } else {
                bArr = new byte[(iArr.length << 2)];
                a(iArr, iArr.length, bArr);
                return bArr;
            }
        }
    }

    public static byte[] k(byte[] bArr, byte[] bArr2) {
        byte[] bN = bN(bArr2);
        if (bArr == null || bN == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr.length % 4 != 0 || bArr.length < 8) {
            return null;
        }
        int i;
        int[] iArr = new int[(bArr.length >>> 2)];
        a(bArr, iArr);
        int length = bN.length % 4 == 0 ? bN.length >>> 2 : (bN.length >>> 2) + 1;
        if (length < 4) {
            length = 4;
        }
        int[] iArr2 = new int[length];
        for (i = 0; i < length; i++) {
            iArr2[i] = 0;
        }
        a(bN, iArr2);
        i = iArr.length - 1;
        int i2 = iArr[0];
        for (int i3 = ((52 / (i + 1)) + 6) * -1640531527; i3 != 0; i3 -= -1640531527) {
            int i4;
            int i5 = (i3 >>> 2) & 3;
            length = i;
            while (length > 0) {
                i4 = iArr[length - 1];
                i2 = iArr[length] - (((i2 ^ i3) + (i4 ^ iArr2[(length & 3) ^ i5])) ^ (((i4 >>> 5) ^ (i2 << 2)) + ((i2 >>> 3) ^ (i4 << 4))));
                iArr[length] = i2;
                length--;
            }
            i4 = iArr[i];
            i2 = iArr[0] - (((iArr2[(length & 3) ^ i5] ^ i4) + (i2 ^ i3)) ^ (((i4 >>> 5) ^ (i2 << 2)) + ((i2 >>> 3) ^ (i4 << 4))));
            iArr[0] = i2;
        }
        length = iArr[i];
        if (length < 0 || length > ((iArr.length - 1) << 2)) {
            return null;
        }
        bArr = new byte[length];
        a(iArr, iArr.length - 1, bArr);
        return bArr;
    }
}
