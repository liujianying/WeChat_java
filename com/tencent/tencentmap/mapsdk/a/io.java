package com.tencent.tencentmap.mapsdk.a;

import java.util.HashMap;
import java.util.Map;

public final class io extends mf {
    static byte[] k = null;
    static Map<String, String> l = null;
    static final /* synthetic */ boolean m;
    public short a = (short) 0;
    public byte b = (byte) 0;
    public int c = 0;
    public int d = 0;
    public String e = null;
    public String f = null;
    public byte[] g;
    public int h = 0;
    public Map<String, String> i;
    public Map<String, String> j;

    static {
        boolean z;
        if (io.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        m = z;
    }

    public io(short s, byte b, int i, int i2, String str, String str2, byte[] bArr, int i3, Map<String, String> map, Map<String, String> map2) {
        this.a = s;
        this.b = b;
        this.c = i;
        this.d = i2;
        this.e = str;
        this.f = str2;
        this.g = bArr;
        this.h = i3;
        this.i = map;
        this.j = map2;
    }

    public final boolean equals(Object obj) {
        io ioVar = (io) obj;
        if (mg.a(1, ioVar.a) && mg.a(1, ioVar.b) && mg.a(1, ioVar.c) && mg.a(1, ioVar.d) && mg.a(Integer.valueOf(1), ioVar.e) && mg.a(Integer.valueOf(1), ioVar.f) && mg.a(Integer.valueOf(1), ioVar.g) && mg.a(1, ioVar.h) && mg.a(Integer.valueOf(1), ioVar.i) && mg.a(Integer.valueOf(1), ioVar.j)) {
            return true;
        }
        return false;
    }

    public final Object clone() {
        Object obj = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (m) {
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
        meVar.a(this.h, 8);
        meVar.a(this.i, 9);
        meVar.a(this.j, 10);
    }

    public final void readFrom(md mdVar) {
        try {
            Map hashMap;
            this.a = mdVar.a(this.a, 1, true);
            this.b = mdVar.a(this.b, 2, true);
            this.c = mdVar.a(this.c, 3, true);
            this.d = mdVar.a(this.d, 4, true);
            this.e = mdVar.a(5, true);
            this.f = mdVar.a(6, true);
            if (k == null) {
                k = new byte[]{(byte) 0};
            }
            this.g = mdVar.a(k, 7, true);
            this.h = mdVar.a(this.h, 8, true);
            if (l == null) {
                hashMap = new HashMap();
                l = hashMap;
                hashMap.put("", "");
            }
            this.i = (Map) mdVar.a(l, 9, true);
            if (l == null) {
                hashMap = new HashMap();
                l = hashMap;
                hashMap.put("", "");
            }
            this.j = (Map) mdVar.a(l, 10, true);
        } catch (Throwable e) {
            System.out.println("RequestPacket decode error " + lz.a(this.g));
            throw new RuntimeException(e);
        }
    }

    public final void display(StringBuilder stringBuilder, int i) {
        mb mbVar = new mb(stringBuilder, i);
        mbVar.a(this.a, "iVersion");
        mbVar.a(this.b, "cPacketType");
        mbVar.a(this.c, "iMessageType");
        mbVar.a(this.d, "iRequestId");
        mbVar.a(this.e, "sServantName");
        mbVar.a(this.f, "sFuncName");
        mbVar.a(this.g, "sBuffer");
        mbVar.a(this.h, "iTimeout");
        mbVar.a(this.i, "context");
        mbVar.a(this.j, "status");
    }
}
