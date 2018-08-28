package com.tencent.tencentmap.mapsdk.a;

public final class ju extends mf {
    public String a = "";
    public int b = 0;
    public String c = "";

    public ju(String str, int i, String str2) {
        this.a = str;
        this.b = i;
        this.c = str2;
    }

    public final void writeTo(me meVar) {
        meVar.a(this.a, 0);
        meVar.a(this.b, 1);
        if (this.c != null) {
            meVar.a(this.c, 2);
        }
    }

    public final void readFrom(md mdVar) {
        this.a = mdVar.a(0, true);
        this.b = mdVar.a(this.b, 1, true);
        this.c = mdVar.a(2, false);
    }
}
