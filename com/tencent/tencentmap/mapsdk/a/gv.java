package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;

public class gv {
    private static gv a;
    private StringBuffer b = new StringBuffer();
    private String c = "";
    private String d = "";

    private gv() {
    }

    public static gv a() {
        if (a == null) {
            a = new gv();
        }
        return a;
    }

    public void a(String str) {
        if (this.b == null) {
            this.b = new StringBuffer();
        }
        this.b.append("####");
        this.b.append(str);
    }

    public void a(int i) {
        this.c = "####ClearCacheStatus: " + i;
    }

    public void a(ic icVar) {
        if (icVar != null) {
            StringBuffer stringBuffer = new StringBuffer();
            GeoPoint p = icVar.p();
            if (p != null) {
                stringBuffer.append("####mapCenter x: " + p.getLatitudeE6() + "  y: " + p.getLongitudeE6());
            }
            stringBuffer.append("  mapScale: " + icVar.j());
            stringBuffer.append("  mapSkew: " + icVar.d());
            stringBuffer.append("  mapRotate: " + icVar.c());
            this.d = stringBuffer.toString();
        }
    }
}
