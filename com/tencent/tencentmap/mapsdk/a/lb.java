package com.tencent.tencentmap.mapsdk.a;

import java.util.Arrays;

public final class lb extends mf implements Cloneable, Comparable<lb> {
    static final /* synthetic */ boolean l = (!lb.class.desiredAssertionStatus());
    public String a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public int f = 0;
    public int g = 0;
    public String h = "";
    public String i = "";
    public String j = "";
    public String k = "";

    public lb(String str, String str2, String str3, String str4, String str5, int i, int i2, String str6, String str7, String str8, String str9) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = i;
        this.g = i2;
        this.h = str6;
        this.i = str7;
        this.j = str8;
        this.k = str9;
    }

    /* renamed from: a */
    public final int compareTo(lb lbVar) {
        int[] iArr = new int[]{mg.a(this.a, lbVar.a), mg.a(this.b, lbVar.b), mg.a(this.c, lbVar.c), mg.a(this.d, lbVar.d), mg.a(this.e, lbVar.e), mg.b(this.f, lbVar.f), mg.b(this.g, lbVar.g), mg.a(this.h, lbVar.h), mg.a(this.i, lbVar.i), mg.a(this.j, lbVar.j), mg.a(this.k, lbVar.k)};
        for (int i = 0; i < 11; i++) {
            if (iArr[i] != 0) {
                return iArr[i];
            }
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        lb lbVar = (lb) obj;
        if (mg.a(this.a, lbVar.a) && mg.a(this.b, lbVar.b) && mg.a(this.c, lbVar.c) && mg.a(this.d, lbVar.d) && mg.a(this.e, lbVar.e) && mg.a(this.f, lbVar.f) && mg.a(this.g, lbVar.g) && mg.a(this.h, lbVar.h) && mg.a(this.i, lbVar.i) && mg.a(this.j, lbVar.j) && mg.a(this.k, lbVar.k)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new int[]{mg.a(this.a), mg.a(this.b), mg.a(this.c), mg.a(this.d), mg.a(this.e), mg.a(this.f), mg.a(this.g), mg.a(this.h), mg.a(this.i), mg.a(this.j), mg.a(this.k)});
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (l) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    public final void writeTo(me meVar) {
        meVar.a(this.a, 0);
        meVar.a(this.b, 1);
        meVar.a(this.c, 2);
        meVar.a(this.d, 3);
        meVar.a(this.e, 4);
        meVar.a(this.f, 5);
        meVar.a(this.g, 6);
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
    }

    public final void readFrom(md mdVar) {
        this.a = mdVar.a(0, true);
        this.b = mdVar.a(1, true);
        this.c = mdVar.a(2, true);
        this.d = mdVar.a(3, true);
        this.e = mdVar.a(4, true);
        this.f = mdVar.a(this.f, 5, true);
        this.g = mdVar.a(this.g, 6, true);
        this.h = mdVar.a(7, false);
        this.i = mdVar.a(8, false);
        this.j = mdVar.a(9, false);
        this.k = mdVar.a(10, false);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        mb mbVar = new mb(stringBuilder, i);
        mbVar.a(this.a, "masterName");
        mbVar.a(this.b, "slaveName");
        mbVar.a(this.c, "interfaceName");
        mbVar.a(this.d, "masterIp");
        mbVar.a(this.e, "slaveIp");
        mbVar.a(this.f, "slavePort");
        mbVar.a(this.g, "returnValue");
        mbVar.a(this.h, "slaveSetName");
        mbVar.a(this.i, "slaveSetArea");
        mbVar.a(this.j, "slaveSetID");
        mbVar.a(this.k, "tafVersion");
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
        mbVar.a(this.k, false);
    }
}
