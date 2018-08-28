package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cr extends cx {
    private static ArrayList<cs> e;
    private static Map<String, String> f;
    public ArrayList<cs> a = null;
    public int b = 0;
    public String c = "";
    public Map<String, String> d = null;

    public final void a(cw cwVar) {
        cwVar.a(this.a, 0);
        cwVar.a(this.b, 1);
        cwVar.a(this.c, 2);
        if (this.d != null) {
            cwVar.a(this.d, 3);
        }
    }

    public final void a(cv cvVar) {
        if (e == null) {
            e = new ArrayList();
            e.add(new cs());
        }
        this.a = (ArrayList) cvVar.a(e, 0, true);
        this.b = cvVar.a(this.b, 1, true);
        this.c = cvVar.a(2, true);
        if (f == null) {
            f = new HashMap();
            f.put("", "");
        }
        this.d = (Map) cvVar.a(f, 3, false);
    }
}
