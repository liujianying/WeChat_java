package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;

public final class lv extends mf implements Cloneable {
    static byte[] k;
    static byte[] l;
    static ArrayList<lx> m;
    static final /* synthetic */ boolean n = (!lv.class.desiredAssertionStatus());
    public short a = (short) 0;
    public int b = 0;
    public String c = "";
    public int d = 0;
    public byte e = (byte) 0;
    public String f = "";
    public String g = "";
    public byte[] h = null;
    public byte[] i = null;
    public ArrayList<lx> j = null;

    public final byte[] a() {
        return this.i;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        lv lvVar = (lv) obj;
        if (mg.a(this.a, lvVar.a) && mg.a(this.b, lvVar.b) && mg.a(this.c, lvVar.c) && mg.a(this.d, lvVar.d) && mg.a(this.e, lvVar.e) && mg.a(this.f, lvVar.f) && mg.a(this.g, lvVar.g) && mg.a(this.h, lvVar.h) && mg.a(this.i, lvVar.i) && mg.a(this.j, lvVar.j)) {
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
            if (n) {
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
        meVar.b(this.e, 4);
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
    }

    public final void readFrom(md mdVar) {
        byte[] bArr;
        this.a = mdVar.a(this.a, 0, true);
        this.b = mdVar.a(this.b, 1, true);
        this.c = mdVar.a(2, true);
        this.d = mdVar.a(this.d, 3, false);
        this.e = mdVar.a(this.e, 4, false);
        this.f = mdVar.a(5, false);
        this.g = mdVar.a(6, false);
        if (k == null) {
            bArr = new byte[1];
            k = bArr;
            bArr[0] = (byte) 0;
        }
        this.h = mdVar.a(k, 7, false);
        if (l == null) {
            bArr = new byte[1];
            l = bArr;
            bArr[0] = (byte) 0;
        }
        this.i = mdVar.a(l, 8, false);
        if (m == null) {
            m = new ArrayList();
            m.add(new lx());
        }
        this.j = (ArrayList) mdVar.a(m, 9, false);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        mb mbVar = new mb(stringBuilder, i);
        mbVar.a(this.a, "shVer");
        mbVar.a(this.b, "eCmd");
        mbVar.a(this.c, "strSubCmd");
        mbVar.a(this.d, "iSeqNo");
        mbVar.a(this.e, "cEncodeType");
        mbVar.a(this.f, "sAppId");
        mbVar.a(this.g, "uin");
        mbVar.a(this.h, "head");
        mbVar.a(this.i, "busiBuff");
        mbVar.a(this.j, "vTag");
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
        mbVar.a(this.j, false);
    }
}
