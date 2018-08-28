package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class fh extends gc {
    private static ArrayList k;
    private static Map l;
    private String a = "";
    private String b = "";
    private ArrayList c = null;
    private String d = "";
    private String e = "";
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private String i = "";
    private Map j = null;

    public fh(String str, String str2, ArrayList arrayList, String str3, String str4, int i, int i2, int i3, String str5, Map map) {
        this.a = str;
        this.b = str2;
        this.c = arrayList;
        this.d = str3;
        this.e = str4;
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.i = str5;
        this.j = map;
    }

    public final void a(ga gaVar) {
        this.a = gaVar.a(0, true);
        this.b = gaVar.a(1, true);
        if (k == null) {
            k = new ArrayList();
            k.add("");
        }
        this.c = (ArrayList) gaVar.a(k, 2, true);
        this.d = gaVar.a(3, false);
        this.e = gaVar.a(4, false);
        this.f = gaVar.a(this.f, 5, false);
        this.g = gaVar.a(this.g, 6, false);
        this.h = gaVar.a(this.h, 7, false);
        this.i = gaVar.a(8, false);
        if (l == null) {
            l = new HashMap();
            l.put("", "");
        }
        this.j = (Map) gaVar.a(l, 9, false);
    }

    public final void a(gb gbVar) {
        gbVar.a(this.a, 0);
        gbVar.a(this.b, 1);
        gbVar.a(this.c, 2);
        if (this.d != null) {
            gbVar.a(this.d, 3);
        }
        if (this.e != null) {
            gbVar.a(this.e, 4);
        }
        gbVar.a(this.f, 5);
        gbVar.a(this.g, 6);
        gbVar.a(this.h, 7);
        if (this.i != null) {
            gbVar.a(this.i, 8);
        }
        if (this.j != null) {
            gbVar.a(this.j, 9);
        }
    }
}
