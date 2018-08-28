package com.tencent.mm.bv;

public final class e {
    public static byte[] bF(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 18);
        }
        return bArr;
    }
}
