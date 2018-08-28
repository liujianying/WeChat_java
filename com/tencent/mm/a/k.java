package com.tencent.mm.a;

public final class k {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return c(bArr, bArr2);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return c(bArr, bArr2);
    }

    private static byte[] c(byte[] bArr, byte[] bArr2) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        byte[] bArr3 = new byte[256];
        for (i = 0; i < 256; i++) {
            bArr3[i] = (byte) i;
        }
        if (bArr2 == null || bArr2.length == 0) {
            bArr3 = null;
        } else {
            i2 = 0;
            i3 = 0;
            for (i = 0; i < 256; i++) {
                i2 = (i2 + ((bArr2[i3] & 255) + (bArr3[i] & 255))) & 255;
                byte b = bArr3[i];
                bArr3[i] = bArr3[i2];
                bArr3[i2] = b;
                i3 = (i3 + 1) % bArr2.length;
            }
        }
        byte[] bArr4 = new byte[bArr.length];
        i = 0;
        i2 = 0;
        while (true) {
            i3 = i4;
            if (i >= bArr.length) {
                return bArr4;
            }
            i3 = (i3 + 1) & 255;
            i4 = ((bArr3[i3] & 255) + i2) & 255;
            byte b2 = bArr3[i3];
            bArr3[i3] = bArr3[i4];
            bArr3[i4] = b2;
            i2 = ((bArr3[i3] & 255) + (bArr3[i4] & 255)) & 255;
            i2 = (byte) (bArr3[i2] ^ bArr[i]);
            bArr4[i] = i2;
            i++;
        }
    }
}
