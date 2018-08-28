package com.tencent.tencentmap.mapsdk.a;

public final class js extends mf {
    public String a = "";
    public int b = 0;
    public int c = 0;

    public js(String str, int i, int i2) {
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    public final void writeTo(me meVar) {
        meVar.a(this.a, 0);
        meVar.a(this.b, 1);
        meVar.a(this.c, 2);
    }

    public final void readFrom(md mdVar) {
        this.a = mdVar.a(0, true);
        this.b = mdVar.a(this.b, 1, true);
        this.c = mdVar.a(this.c, 2, false);
    }
}
