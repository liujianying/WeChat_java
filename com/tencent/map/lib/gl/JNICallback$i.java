package com.tencent.map.lib.gl;

import com.tencent.tencentmap.mapsdk.a.jm;
import java.util.Arrays;

public class JNICallback$i {
    public float a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    byte[] f;

    private JNICallback$i() {
        this.f = new byte[4];
    }

    public void a(byte[] bArr) {
        Arrays.fill(this.f, (byte) 0);
        System.arraycopy(bArr, 0, this.f, 0, 4);
        this.a = jm.c(this.f);
        System.arraycopy(bArr, 4, this.f, 0, 4);
        this.b = jm.a(this.f);
        System.arraycopy(bArr, 8, this.f, 0, 4);
        this.c = jm.a(this.f);
        System.arraycopy(bArr, 12, this.f, 0, 4);
        this.d = jm.a(this.f);
        System.arraycopy(bArr, 16, this.f, 0, 1);
        this.e = jm.b(this.f);
    }
}
