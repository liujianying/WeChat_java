package com.tencent.tencentmap.mapsdk.a;

public final class li extends mf implements Cloneable {
    static final /* synthetic */ boolean j = (!li.class.desiredAssertionStatus());
    public String a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public int g = 0;
    public int h = 0;
    public int i = 0;

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        li liVar = (li) obj;
        if (mg.a(this.a, liVar.a) && mg.a(this.b, liVar.b) && mg.a(this.c, liVar.c) && mg.a(this.d, liVar.d) && mg.a(this.e, liVar.e) && mg.a(this.f, liVar.f) && mg.a(this.g, liVar.g) && mg.a(this.h, liVar.h) && mg.a(this.i, liVar.i)) {
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
            if (j) {
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
        meVar.a(this.h, 7);
        meVar.a(this.i, 8);
    }

    public final void readFrom(md mdVar) {
        this.a = mdVar.a(0, true);
        this.b = mdVar.a(1, true);
        this.c = mdVar.a(2, true);
        this.d = mdVar.a(3, true);
        this.e = mdVar.a(4, true);
        this.f = mdVar.a(5, true);
        this.g = mdVar.a(this.g, 6, true);
        this.h = mdVar.a(this.h, 7, true);
        this.i = mdVar.a(this.i, 8, true);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        mb mbVar = new mb(stringBuilder, i);
        mbVar.a(this.a, "unid");
        mbVar.a(this.b, "masterName");
        mbVar.a(this.c, "slaveName");
        mbVar.a(this.d, "interfaceName");
        mbVar.a(this.e, "masterIp");
        mbVar.a(this.f, "slaveIp");
        mbVar.a(this.g, "depth");
        mbVar.a(this.h, "width");
        mbVar.a(this.i, "parentWidth");
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
        mbVar.a(this.i, false);
    }
}
