package com.tencent.tencentmap.mapsdk.a;

public final class cn extends cx {
    private static byte[] m;
    public byte a = (byte) 0;
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public int f = 0;
    public byte[] g = null;
    public byte h = (byte) 0;
    public byte i = (byte) 0;
    public String j = "";
    public String k = "";
    public String l = "";

    public final void a(cw cwVar) {
        cwVar.a(this.a, 0);
        cwVar.a(this.b, 1);
        cwVar.a(this.c, 2);
        cwVar.a(this.d, 3);
        cwVar.a(this.e, 4);
        cwVar.a(this.f, 5);
        cwVar.a(this.g, 6);
        cwVar.a(this.h, 7);
        cwVar.a(this.i, 8);
        if (this.j != null) {
            cwVar.a(this.j, 9);
        }
        if (this.k != null) {
            cwVar.a(this.k, 10);
        }
        if (this.l != null) {
            cwVar.a(this.l, 11);
        }
    }

    public final void a(cv cvVar) {
        this.a = cvVar.a(this.a, 0, true);
        this.b = cvVar.a(1, true);
        this.c = cvVar.a(2, true);
        this.d = cvVar.a(3, true);
        this.e = cvVar.a(4, true);
        this.f = cvVar.a(this.f, 5, true);
        if (m == null) {
            byte[] bArr = new byte[1];
            m = bArr;
            bArr[0] = (byte) 0;
        }
        this.g = cvVar.b(6, true);
        this.h = cvVar.a(this.h, 7, true);
        this.i = cvVar.a(this.i, 8, true);
        this.j = cvVar.a(9, false);
        this.k = cvVar.a(10, false);
        this.l = cvVar.a(11, false);
    }
}
