package com.tencent.tencentmap.mapsdk.a;

public final class lu extends mf implements Cloneable {
    static lt s;
    static final /* synthetic */ boolean t = (!lu.class.desiredAssertionStatus());
    public long a = 0;
    public lt b = null;
    public long c = 0;
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    public String i = "";
    public String j = "";
    public String k = "";
    public String l = "";
    public String m = "";
    public String n = "";
    public String o = "";
    public String p = "";
    public String q = "";
    public String r = "";

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        lu luVar = (lu) obj;
        if (mg.a(this.a, luVar.a) && mg.a(this.b, luVar.b) && mg.a(this.c, luVar.c) && mg.a(this.d, luVar.d) && mg.a(this.e, luVar.e) && mg.a(this.f, luVar.f) && mg.a(this.g, luVar.g) && mg.a(this.h, luVar.h) && mg.a(this.i, luVar.i) && mg.a(this.j, luVar.j) && mg.a(this.k, luVar.k) && mg.a(this.l, luVar.l) && mg.a(this.m, luVar.m) && mg.a(this.n, luVar.n) && mg.a(this.o, luVar.o) && mg.a(this.p, luVar.p) && mg.a(this.q, luVar.q) && mg.a(this.r, luVar.r)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            return 0;
        }
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (t) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    public final void writeTo(me meVar) {
        meVar.a(this.a, 0);
        if (this.b != null) {
            meVar.a(this.b, 1);
        }
        meVar.a(this.c, 2);
        if (this.d != null) {
            meVar.a(this.d, 3);
        }
        if (this.e != null) {
            meVar.a(this.e, 4);
        }
        if (this.f != null) {
            meVar.a(this.f, 5);
        }
        if (this.g != null) {
            meVar.a(this.g, 6);
        }
        if (this.h != null) {
            meVar.a(this.h, 7);
        }
        if (this.i != null) {
            meVar.a(this.i, 8);
        }
        if (this.j != null) {
            meVar.a(this.j, 9);
        }
        if (this.k != null) {
            meVar.a(this.k, 10);
        }
        if (this.l != null) {
            meVar.a(this.l, 11);
        }
        if (this.m != null) {
            meVar.a(this.m, 12);
        }
        if (this.n != null) {
            meVar.a(this.n, 13);
        }
        if (this.o != null) {
            meVar.a(this.o, 14);
        }
        if (this.p != null) {
            meVar.a(this.p, 15);
        }
        if (this.q != null) {
            meVar.a(this.q, 16);
        }
        if (this.r != null) {
            meVar.a(this.r, 17);
        }
    }

    public final void readFrom(md mdVar) {
        this.a = mdVar.a(this.a, 0, true);
        if (s == null) {
            s = new lt();
        }
        this.b = (lt) mdVar.a(s, 1, false);
        this.c = mdVar.a(this.c, 2, false);
        this.d = mdVar.a(3, false);
        this.e = mdVar.a(4, false);
        this.f = mdVar.a(5, false);
        this.g = mdVar.a(6, false);
        this.h = mdVar.a(7, false);
        this.i = mdVar.a(8, false);
        this.j = mdVar.a(9, false);
        this.k = mdVar.a(10, false);
        this.l = mdVar.a(11, false);
        this.m = mdVar.a(12, false);
        this.n = mdVar.a(13, false);
        this.o = mdVar.a(14, false);
        this.p = mdVar.a(15, false);
        this.q = mdVar.a(16, false);
        this.r = mdVar.a(17, false);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        mb mbVar = new mb(stringBuilder, i);
        mbVar.a(this.a, "lCurrTime");
        mbVar.a(this.b, "stResult");
        mbVar.a(this.c, "uAccIp");
        mbVar.a(this.d, "strSessionId");
        mbVar.a(this.e, "strLC");
        mbVar.a(this.f, "strToken");
        mbVar.a(this.g, "strFr");
        mbVar.a(this.h, "strPf");
        mbVar.a(this.i, "strImei");
        mbVar.a(this.j, "strMobver");
        mbVar.a(this.k, "strNettp");
        mbVar.a(this.l, "strImsi");
        mbVar.a(this.m, "strOsVersion");
        mbVar.a(this.n, "strSoftVersion");
        mbVar.a(this.o, "strOfflineVersion");
        mbVar.a(this.p, "strChannel");
        mbVar.a(this.q, "strMachineModel");
        mbVar.a(this.r, "strUserNetType");
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        mb mbVar = new mb(stringBuilder, i);
        mbVar.a(this.a, true);
        mbVar.a(this.b, true);
        mbVar.a(this.c, true);
        mbVar.a(this.d, true);
        mbVar.a(this.e, true);
        mbVar.a(this.f, true);
        mbVar.a(this.g, true);
        mbVar.a(this.h, true);
        mbVar.a(this.i, true);
        mbVar.a(this.j, true);
        mbVar.a(this.k, true);
        mbVar.a(this.l, true);
        mbVar.a(this.m, true);
        mbVar.a(this.n, true);
        mbVar.a(this.o, true);
        mbVar.a(this.p, true);
        mbVar.a(this.q, true);
        mbVar.a(this.r, false);
    }
}
