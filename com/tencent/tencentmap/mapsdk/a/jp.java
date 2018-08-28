package com.tencent.tencentmap.mapsdk.a;

import java.util.HashMap;
import java.util.Map;

public final class jp extends mf implements Cloneable {
    static byte[] i;
    static Map<String, String> j;
    static final /* synthetic */ boolean k = (!jp.class.desiredAssertionStatus());
    public short a = (short) 0;
    public byte b = (byte) 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public byte[] f = null;
    public Map<String, String> g = null;
    public String h = "";

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        jp jpVar = (jp) obj;
        if (mg.a(this.a, jpVar.a) && mg.a(this.b, jpVar.b) && mg.a(this.c, jpVar.c) && mg.a(this.d, jpVar.d) && mg.a(this.e, jpVar.e) && mg.a(this.f, jpVar.f) && mg.a(this.g, jpVar.g) && mg.a(this.h, jpVar.h)) {
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
            if (k) {
                return obj;
            }
            throw new AssertionError();
        }
    }

    public final void writeTo(me meVar) {
        meVar.a(this.a, 1);
        meVar.b(this.b, 2);
        meVar.a(this.c, 3);
        meVar.a(this.d, 4);
        meVar.a(this.e, 5);
        meVar.a(this.f, 6);
        meVar.a(this.g, 7);
        if (this.h != null) {
            meVar.a(this.h, 8);
        }
    }

    public final void readFrom(md mdVar) {
        this.a = mdVar.a(this.a, 1, true);
        this.b = mdVar.a(this.b, 2, true);
        this.c = mdVar.a(this.c, 3, true);
        this.d = mdVar.a(this.d, 4, true);
        this.e = mdVar.a(this.e, 5, true);
        if (i == null) {
            byte[] bArr = new byte[1];
            i = bArr;
            bArr[0] = (byte) 0;
        }
        this.f = mdVar.a(i, 6, true);
        if (j == null) {
            j = new HashMap();
            j.put("", "");
        }
        this.g = (Map) mdVar.a(j, 7, true);
        this.h = mdVar.a(8, false);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        mb mbVar = new mb(stringBuilder, i);
        mbVar.a(this.a, "iVersion");
        mbVar.a(this.b, "cPacketType");
        mbVar.a(this.c, "iRequestId");
        mbVar.a(this.d, "iMessageType");
        mbVar.a(this.e, "iRet");
        mbVar.a(this.f, "sBuffer");
        mbVar.a(this.g, "status");
        mbVar.a(this.h, "sResultDesc");
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
        mbVar.a(this.h, false);
    }
}
