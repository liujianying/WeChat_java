package com.tencent.tencentmap.mapsdk.a;

import android.graphics.PointF;

class hx$4 extends hi {
    final /* synthetic */ long j;
    final /* synthetic */ long k;
    final /* synthetic */ PointF l;
    final /* synthetic */ hx m;

    hx$4(hx hxVar, int i, double[] dArr, long j, long j2, PointF pointF) {
        this.m = hxVar;
        this.j = j;
        this.k = j2;
        this.l = pointF;
        super(i, dArr);
    }

    public void b() {
        hx.a(this.m, false);
    }

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis() - this.j;
        if (currentTimeMillis > this.k) {
            hx.a(this.m, false);
            return true;
        }
        if (this.l.x != 0.0f) {
            this.b[0] = gs.a(currentTimeMillis, this.l.x, -this.l.x, this.k);
        }
        if (this.l.y != 0.0f) {
            this.b[1] = gs.a(currentTimeMillis, this.l.y, -this.l.y, this.k);
        }
        return false;
    }
}
