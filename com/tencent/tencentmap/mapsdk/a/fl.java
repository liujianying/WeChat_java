package com.tencent.tencentmap.mapsdk.a;

import java.util.Arrays;

public final class fl extends mf implements Cloneable, Comparable<fl> {
    static final /* synthetic */ boolean j = (!fl.class.desiredAssertionStatus());
    public String a = "";
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public String h = "";
    public int i = 0;

    /* renamed from: a */
    public final int compareTo(fl flVar) {
        int[] iArr = new int[]{mg.a(this.a, flVar.a), mg.b(this.b, flVar.b), mg.b(this.c, flVar.c), mg.b(this.d, flVar.d), mg.b(this.e, flVar.e), mg.b(this.i, flVar.i)};
        for (int i = 0; i < 6; i++) {
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
        fl flVar = (fl) obj;
        if (mg.a(this.a, flVar.a) && mg.a(this.b, flVar.b) && mg.a(this.c, flVar.c) && mg.a(this.d, flVar.d) && mg.a(this.e, flVar.e) && mg.a(this.i, flVar.i)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new int[]{mg.a(this.a), mg.a(this.b), mg.a(this.c), mg.a(this.d), mg.a(this.e), mg.a(this.i)});
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
        if (this.h != null) {
            meVar.a(this.h, 7);
        }
        meVar.a(this.i, 8);
    }

    public final void readFrom(md mdVar) {
        this.a = mdVar.a(0, true);
        this.b = mdVar.a(this.b, 1, true);
        this.c = mdVar.a(this.c, 2, true);
        this.d = mdVar.a(this.d, 3, true);
        this.e = mdVar.a(this.e, 4, true);
        this.f = mdVar.a(this.f, 5, false);
        this.g = mdVar.a(this.g, 6, false);
        this.h = mdVar.a(7, false);
        this.i = mdVar.a(this.i, 8, false);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        mb mbVar = new mb(stringBuilder, i);
        mbVar.a(this.a, "host");
        mbVar.a(this.b, "port");
        mbVar.a(this.c, "timeout");
        mbVar.a(this.d, "istcp");
        mbVar.a(this.e, "grid");
        mbVar.a(this.f, "groupworkid");
        mbVar.a(this.g, "grouprealid");
        mbVar.a(this.h, "setId");
        mbVar.a(this.i, "qos");
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
