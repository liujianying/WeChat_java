package com.tencent.tencentmap.mapsdk.a;

import android.graphics.PointF;

public final class rn extends rl {
    private PointF d;
    private double e;
    private double f;

    public rn(sl slVar, double d, PointF pointF, long j, tt ttVar) {
        super(slVar, j, ttVar);
        this.e = d;
        this.d = pointF;
    }

    protected final void a(float f) {
        this.b.a(this.f * ((double) f), this.d, false, null);
    }

    protected final void c() {
        double c = this.b.c();
        this.f = this.e - c;
        new StringBuilder("newZoom:").append(this.e).append(",oldZoom=").append(c);
    }

    protected final void d() {
        this.b.a(this.e, this.d, false, 0, null);
    }
}
