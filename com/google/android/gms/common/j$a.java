package com.google.android.gms.common;

import com.google.android.gms.common.internal.w;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class j$a {
    private int aQn;

    protected j$a(byte[] bArr) {
        w.e(bArr.length == 25, "cert hash data has incorrect length");
        this.aQn = Arrays.hashCode(bArr);
    }

    protected static byte[] bm(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof j$a)) {
            return false;
        }
        return Arrays.equals(getBytes(), ((j$a) obj).getBytes());
    }

    abstract byte[] getBytes();

    public int hashCode() {
        return this.aQn;
    }
}
