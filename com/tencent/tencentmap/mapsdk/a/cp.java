package com.tencent.tencentmap.mapsdk.a;

public final class cp extends cx implements Cloneable {
    public String a = "";
    public String b = "";
    public String c = "";
    public boolean d = true;
    public long e = 0;
    public long f = 0;
    public String g = "";
    public long h = 0;
    private int i = 0;

    public final void a(cw cwVar) {
        cwVar.a(this.a, 0);
        cwVar.a(this.b, 1);
        cwVar.a(this.c, 2);
        cwVar.a(this.d);
        cwVar.a(this.e, 4);
        cwVar.a(this.f, 5);
        cwVar.a(this.g, 6);
        cwVar.a(this.h, 7);
        cwVar.a(this.i, 8);
    }

    public final void a(cv cvVar) {
        this.a = cvVar.a(0, true);
        this.b = cvVar.a(1, true);
        this.c = cvVar.a(2, true);
        this.d = cvVar.a((byte) 0, 3, true) != (byte) 0;
        this.e = cvVar.a(this.e, 4, true);
        this.f = cvVar.a(this.f, 5, true);
        this.g = cvVar.a(6, true);
        this.h = cvVar.a(this.h, 7, true);
        this.i = cvVar.a(this.i, 8, false);
    }
}
