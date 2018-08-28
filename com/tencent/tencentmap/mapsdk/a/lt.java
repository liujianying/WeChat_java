package com.tencent.tencentmap.mapsdk.a;

public final class lt extends mf implements Cloneable {
    static final /* synthetic */ boolean d = (!lt.class.desiredAssertionStatus());
    public int a = 0;
    public String b = "";
    public int c = 0;

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        lt ltVar = (lt) obj;
        if (mg.a(this.a, ltVar.a) && mg.a(this.b, ltVar.b) && mg.a(this.c, ltVar.c)) {
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
        meVar.a(this.c, 2);
    }

    public final void readFrom(md mdVar) {
        this.a = mdVar.a(this.a, 0, true);
        this.b = mdVar.a(1, true);
        this.c = mdVar.a(this.c, 2, false);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        mb mbVar = new mb(stringBuilder, i);
        mbVar.a(this.a, "iErrCode");
        mbVar.a(this.b, "strErrDesc");
        mbVar.a(this.c, "iSubErrCode");
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        mb mbVar = new mb(stringBuilder, i);
        mbVar.a(this.a, true);
        mbVar.a(this.b, true);
        mbVar.a(this.c, false);
    }
}
