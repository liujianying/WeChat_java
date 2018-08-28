package com.tencent.tencentmap.mapsdk.a;

import android.view.View;

public class lq {
    private ks a = null;
    private lm b = null;
    private lo c;

    public lq(View view) {
        this.a = (ks) view;
    }

    public void a(lo loVar) {
        this.c = loVar;
    }

    public lp a(nj njVar, boolean z) {
        if (this.a == null) {
            return null;
        }
        this.b = new lm(this.a, this.c, njVar, z);
        this.b.c = true;
        this.b.c(Float.NEGATIVE_INFINITY);
        this.b.c();
        this.a.a(this.b);
        this.a.getMap().a();
        return new lp(this.b, this, this.b.v());
    }

    public void a(String str) {
        if (this.a != null) {
            this.a.b(str, true);
            this.a.getMap().a();
        }
    }
}
