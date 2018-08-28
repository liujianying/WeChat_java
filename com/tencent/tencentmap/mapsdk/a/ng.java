package com.tencent.tencentmap.mapsdk.a;

import java.util.Arrays;

public class ng {
    private int a;
    private int b;
    private int c;
    private byte[] d = new byte[4];

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public void a(byte[] bArr) {
        Arrays.fill(this.d, (byte) 0);
        System.arraycopy(bArr, 0, this.d, 0, 4);
        this.a = jm.a(this.d);
        System.arraycopy(bArr, 4, this.d, 0, 4);
        this.b = jm.a(this.d);
        System.arraycopy(bArr, 8, this.d, 0, 4);
        this.c = jm.a(this.d);
    }
}
