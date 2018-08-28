package com.tencent.tencentmap.mapsdk.a;

import android.support.design.a$i;

public class hi {
    public static final hi g = new hi(1, null);
    public static final hi h = new hi(2, null, true);
    public static final hi i = new hi(a$i.AppCompatTheme_editTextStyle, null);
    public int a;
    public double[] b;
    public long c;
    public boolean d;
    public boolean e;
    public Runnable f;
    private hj j;

    public hi() {
        this.c = -1;
        this.d = false;
    }

    public hi(int i, double[] dArr) {
        this(i, dArr, false);
    }

    public hi(int i, double[] dArr, boolean z) {
        this.c = -1;
        this.d = false;
        this.a = i;
        this.b = dArr;
        this.e = z;
    }

    public hi(Runnable runnable) {
        this.c = -1;
        this.d = false;
        this.a = 6;
        this.f = runnable;
    }

    protected boolean a() {
        return true;
    }

    boolean a(hk$a hk_a) {
        if (this.j != null) {
            this.j.a();
        }
        boolean a = a();
        hk_a.a(this);
        return a;
    }

    public void b() {
        if (this.j != null) {
            this.j.b();
        }
    }

    public void c() {
        if (this.j != null) {
            this.j.c();
        }
    }
}
