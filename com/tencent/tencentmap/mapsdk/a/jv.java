package com.tencent.tencentmap.mapsdk.a;

public final class jv extends mf {
    public String a = "";
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public String e = "";
    public String f = "";
    public int g = 0;

    public final void writeTo(me meVar) {
        meVar.a(this.a, 0);
        meVar.a(this.b, 1);
        meVar.a(this.c, 2);
        meVar.a(this.d, 3);
        if (this.e != null) {
            meVar.a(this.e, 4);
        }
        if (this.f != null) {
            meVar.a(this.f, 5);
        }
        meVar.a(this.g, 6);
    }

    public final void readFrom(md mdVar) {
        this.a = mdVar.a(0, true);
        this.b = mdVar.a(this.b, 1, true);
        this.c = mdVar.a(this.c, 2, true);
        this.d = mdVar.a(this.d, 3, false);
        this.e = mdVar.a(4, false);
        this.f = mdVar.a(5, false);
        this.g = mdVar.a(this.g, 6, false);
    }
}
