package com.tencent.tencentmap.mapsdk.a;

import java.util.HashMap;
import java.util.Map;

public final class cz extends cx {
    private static byte[] k = null;
    private static Map<String, String> l = null;
    public short a = (short) 3;
    public int b = 0;
    public String c = null;
    public String d = null;
    public byte[] e;
    private byte f = (byte) 0;
    private int g = 0;
    private int h = 0;
    private Map<String, String> i;
    private Map<String, String> j;

    public final void a(cw cwVar) {
        cwVar.a(this.a, 1);
        cwVar.a(this.f, 2);
        cwVar.a(this.g, 3);
        cwVar.a(this.b, 4);
        cwVar.a(this.c, 5);
        cwVar.a(this.d, 6);
        cwVar.a(this.e, 7);
        cwVar.a(this.h, 8);
        cwVar.a(this.i, 9);
        cwVar.a(this.j, 10);
    }

    public final void a(cv cvVar) {
        try {
            Map hashMap;
            this.a = cvVar.a(this.a, 1, true);
            this.f = cvVar.a(this.f, 2, true);
            this.g = cvVar.a(this.g, 3, true);
            this.b = cvVar.a(this.b, 4, true);
            this.c = cvVar.a(5, true);
            this.d = cvVar.a(6, true);
            if (k == null) {
                k = new byte[]{(byte) 0};
            }
            this.e = cvVar.b(7, true);
            this.h = cvVar.a(this.h, 8, true);
            if (l == null) {
                hashMap = new HashMap();
                l = hashMap;
                hashMap.put("", "");
            }
            this.i = (Map) cvVar.a(l, 9, true);
            if (l == null) {
                hashMap = new HashMap();
                l = hashMap;
                hashMap.put("", "");
            }
            this.j = (Map) cvVar.a(l, 10, true);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
