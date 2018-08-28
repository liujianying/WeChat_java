package com.tencent.tencentmap.mapsdk.a;

public class lo$a {
    public final int a;
    public final int b;
    public final int c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    private String h;
    private String i;
    private boolean j;

    public lo$a(int i, int i2, int i3, String str, String str2, String str3, String str4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
    }

    public String a() {
        return this.i;
    }

    public void a(String str) {
        if (this.i == null || !this.i.equals(str)) {
            this.j = true;
            this.i = str;
            if (str == null) {
                return;
            }
            if (str.equals("taiwanmap")) {
                this.h = this.e;
                return;
            } else {
                this.h = this.d;
                return;
            }
        }
        this.j = false;
    }

    public boolean b() {
        return this.j;
    }

    public void c() {
        this.j = false;
    }

    public String d() {
        return this.h;
    }
}
