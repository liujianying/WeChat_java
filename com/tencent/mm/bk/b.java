package com.tencent.mm.bk;

import java.io.UnsupportedEncodingException;

public final class b {
    public byte[] lR;

    private b() {
    }

    public b(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public b(byte[] bArr, int i, int i2) {
        this.lR = new byte[i2];
        System.arraycopy(bArr, i, this.lR, 0, i2);
    }

    public static b t(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    public static b bi(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        return new b(bArr);
    }

    public static b Uw(String str) {
        try {
            b bVar = new b();
            bVar.lR = str.getBytes("UTF-8");
            return bVar;
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public final b Cz(int i) {
        Object obj = new byte[i];
        if (this.lR.length >= i) {
            System.arraycopy(this.lR, 0, obj, 0, i - 1);
            this.lR = obj;
        } else {
            System.arraycopy(this.lR, 0, obj, 0, this.lR.length);
            this.lR = obj;
        }
        return this;
    }

    public final void bj(byte[] bArr) {
        System.arraycopy(this.lR, 0, bArr, 4, this.lR.length);
    }

    public final void f(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.lR, i, bArr, i2, i3);
    }

    public final byte[] toByteArray() {
        int length = this.lR.length;
        Object obj = new byte[length];
        System.arraycopy(this.lR, 0, obj, 0, length);
        return obj;
    }

    public final String cfV() {
        int i = 0;
        while (i < this.lR.length && this.lR[i] != (byte) 0) {
            try {
                i++;
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UTF-8 not supported?");
            }
        }
        return new String(this.lR, 0, i, "UTF-8");
    }
}
