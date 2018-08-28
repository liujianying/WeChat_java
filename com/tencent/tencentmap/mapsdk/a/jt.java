package com.tencent.tencentmap.mapsdk.a;

public final class jt extends mf {
    static byte[] h;
    public String a = "";
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public byte[] f = null;
    public String g = "";

    public final void writeTo(me meVar) {
        meVar.a(this.a, 0);
        meVar.a(this.b, 1);
        meVar.a(this.c, 2);
        meVar.a(this.d, 3);
        meVar.a(this.e, 4);
        if (this.f != null) {
            meVar.a(this.f, 5);
        }
        if (this.g != null) {
            meVar.a(this.g, 6);
        }
    }

    static {
        byte[] bArr = new byte[1];
        h = bArr;
        bArr[0] = (byte) 0;
    }

    public final void readFrom(md mdVar) {
        this.a = mdVar.a(0, true);
        this.b = mdVar.a(this.b, 1, true);
        this.c = mdVar.a(this.c, 2, false);
        this.d = mdVar.a(this.d, 3, false);
        this.e = mdVar.a(this.e, 4, false);
        this.f = mdVar.a(h, 5, false);
        this.g = mdVar.a(6, false);
    }
}
