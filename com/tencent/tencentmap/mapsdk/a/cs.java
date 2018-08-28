package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cs extends cx {
    private static Map<String, String> g;
    private static ArrayList<String> h;
    private static ArrayList<String> i;
    public byte a = (byte) 0;
    public byte b = (byte) 0;
    public String c = "";
    public Map<String, String> d = null;
    public ArrayList<String> e = null;
    public ArrayList<String> f = null;

    public final void a(cw cwVar) {
        cwVar.a(this.a, 0);
        cwVar.a(this.b, 1);
        cwVar.a(this.c, 2);
        cwVar.a(this.d, 3);
        if (this.e != null) {
            cwVar.a(this.e, 4);
        }
        if (this.f != null) {
            cwVar.a(this.f, 6);
        }
    }

    public final void a(cv cvVar) {
        this.a = cvVar.a(this.a, 0, true);
        this.b = cvVar.a(this.b, 1, true);
        this.c = cvVar.a(2, true);
        if (g == null) {
            g = new HashMap();
            g.put("", "");
        }
        this.d = (Map) cvVar.a(g, 3, true);
        if (h == null) {
            h = new ArrayList();
            h.add("");
        }
        this.e = (ArrayList) cvVar.a(h, 4, false);
        if (i == null) {
            i = new ArrayList();
            i.add("");
        }
        this.f = (ArrayList) cvVar.a(i, 6, false);
    }
}
