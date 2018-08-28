package com.tencent.tencentmap.mapsdk.a;

public final class lx extends mf implements Cloneable {
    static byte[] c;
    static final /* synthetic */ boolean d = (!lx.class.desiredAssertionStatus());
    public String a = "";
    public byte[] b = null;

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        lx lxVar = (lx) obj;
        if (mg.a(this.a, lxVar.a) && mg.a(this.b, lxVar.b)) {
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
            if (d) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    public final void writeTo(me meVar) {
        meVar.a(this.a, 0);
        meVar.a(this.b, 1);
    }

    public final void readFrom(md mdVar) {
        this.a = mdVar.a(0, true);
        if (c == null) {
            byte[] bArr = new byte[1];
            c = bArr;
            bArr[0] = (byte) 0;
        }
        this.b = mdVar.a(c, 1, true);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        mb mbVar = new mb(stringBuilder, i);
        mbVar.a(this.a, "strId");
        mbVar.a(this.b, "value");
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        mb mbVar = new mb(stringBuilder, i);
        mbVar.a(this.a, true);
        mbVar.a(this.b, false);
    }
}
