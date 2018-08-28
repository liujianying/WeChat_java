package com.tencent.tencentmap.mapsdk.a;

import java.util.HashMap;
import java.util.Map;

public final class ge extends gc {
    private static byte[] k = null;
    private static Map l = null;
    public short a = (short) 3;
    public int b = 0;
    public String c = null;
    public String d = null;
    public byte[] e;
    private byte f = (byte) 0;
    private int g = 0;
    private int h = 0;
    private Map i;
    private Map j;

    public final void a(ga gaVar) {
        try {
            Map hashMap;
            this.a = gaVar.a(this.a, 1, true);
            this.f = gaVar.a(this.f, 2, true);
            this.g = gaVar.a(this.g, 3, true);
            this.b = gaVar.a(this.b, 4, true);
            this.c = gaVar.a(5, true);
            this.d = gaVar.a(6, true);
            if (k == null) {
                k = new byte[]{(byte) 0};
            }
            this.e = gaVar.b(7, true);
            this.h = gaVar.a(this.h, 8, true);
            if (l == null) {
                hashMap = new HashMap();
                l = hashMap;
                hashMap.put("", "");
            }
            this.i = (Map) gaVar.a(l, 9, true);
            if (l == null) {
                hashMap = new HashMap();
                l = hashMap;
                hashMap.put("", "");
            }
            this.j = (Map) gaVar.a(l, 10, true);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void a(gb gbVar) {
        gbVar.a(this.a, 1);
        gbVar.a(this.f, 2);
        gbVar.a(this.g, 3);
        gbVar.a(this.b, 4);
        gbVar.a(this.c, 5);
        gbVar.a(this.d, 6);
        gbVar.a(this.e, 7);
        gbVar.a(this.h, 8);
        gbVar.a(this.i, 9);
        gbVar.a(this.j, 10);
    }
}
