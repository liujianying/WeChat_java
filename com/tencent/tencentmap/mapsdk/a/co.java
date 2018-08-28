package com.tencent.tencentmap.mapsdk.a;

public final class co extends cx {
    private static byte[] j;
    public byte a = (byte) 0;
    public int b = 0;
    public byte[] c = null;
    public String d = "";
    public long e = 0;
    private byte f = (byte) 0;
    private byte g = (byte) 0;
    private String h = "";
    private String i = "";

    public final void a(cw cwVar) {
        cwVar.a(this.a, 0);
        cwVar.a(this.b, 1);
        cwVar.a(this.c, 2);
        cwVar.a(this.d, 3);
        cwVar.a(this.f, 4);
        cwVar.a(this.g, 5);
        cwVar.a(this.e, 6);
        if (this.h != null) {
            cwVar.a(this.h, 7);
        }
        if (this.i != null) {
            cwVar.a(this.i, 8);
        }
    }

    public final void a(cv cvVar) {
        this.a = cvVar.a(this.a, 0, true);
        this.b = cvVar.a(this.b, 1, true);
        if (j == null) {
            byte[] bArr = new byte[1];
            j = bArr;
            bArr[0] = (byte) 0;
        }
        this.c = cvVar.b(2, true);
        this.d = cvVar.a(3, true);
        this.f = cvVar.a(this.f, 4, true);
        this.g = cvVar.a(this.g, 5, true);
        this.e = cvVar.a(this.e, 6, true);
        this.h = cvVar.a(7, false);
        this.i = cvVar.a(8, false);
    }
}
