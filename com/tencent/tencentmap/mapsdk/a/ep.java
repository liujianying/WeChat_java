package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;

public class ep {
    private String a = "";
    private int b = -1;

    public ep(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public String a() {
        return this.a;
    }

    public boolean a(ep epVar) {
        return epVar != null && this.a.equals(epVar.a) && this.b == epVar.b;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split(":");
        if (split.length != 2) {
            return false;
        }
        this.a = split[0];
        try {
            this.b = Integer.parseInt(split[1]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int b() {
        return this.b;
    }

    public String c() {
        return this.a + ":" + this.b;
    }

    public String d() {
        return this.b == -1 ? this.a : c();
    }

    public String toString() {
        return d();
    }
}
