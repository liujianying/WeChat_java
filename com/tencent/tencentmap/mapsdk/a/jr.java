package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;

public final class jr extends mf {
    static ArrayList<ju> e = new ArrayList();
    public ArrayList<ju> a = null;
    public String b = "";
    public String c = "";
    public String d = "";

    public jr(ArrayList<ju> arrayList, String str, String str2, String str3) {
        this.a = arrayList;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public final void writeTo(me meVar) {
        meVar.a(this.a, 0);
        if (this.b != null) {
            meVar.a(this.b, 1);
        }
        if (this.c != null) {
            meVar.a(this.c, 2);
        }
        if (this.d != null) {
            meVar.a(this.d, 3);
        }
    }

    static {
        e.add(new ju());
    }

    public final void readFrom(md mdVar) {
        this.a = (ArrayList) mdVar.a(e, 0, true);
        this.b = mdVar.a(1, false);
        this.c = mdVar.a(2, false);
        this.d = mdVar.a(3, false);
    }
}
