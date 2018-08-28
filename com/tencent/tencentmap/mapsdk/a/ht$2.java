package com.tencent.tencentmap.mapsdk.a;

class ht$2 extends hi {
    final /* synthetic */ long j;
    final /* synthetic */ float k;
    final /* synthetic */ float l;
    final /* synthetic */ double m;
    final /* synthetic */ double n;
    final /* synthetic */ double o;
    final /* synthetic */ double p;
    final /* synthetic */ ht q;

    ht$2(ht htVar, int i, double[] dArr, boolean z, long j, float f, float f2, double d, double d2, double d3, double d4) {
        this.q = htVar;
        this.j = j;
        this.k = f;
        this.l = f2;
        this.m = d;
        this.n = d2;
        this.o = d3;
        this.p = d4;
        super(i, dArr, z);
    }

    public boolean a() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis() - this.j;
        double b = gs.b(currentTimeMillis, 0.0f, this.k, 5000);
        double b2 = gs.b(currentTimeMillis, 0.0f, this.l, 5000);
        double[] dArr = this.b;
        dArr[2] = dArr[2] + Math.abs(b);
        dArr = this.b;
        dArr[3] = dArr[3] + Math.abs(b2);
        boolean z2 = this.b[2] >= Math.abs(this.m);
        if (this.b[3] >= Math.abs(this.n)) {
            z = true;
        } else {
            z = false;
        }
        if (z2) {
            this.b[0] = this.o - ((double) this.q.o());
        } else {
            this.b[0] = b;
        }
        if (z) {
            this.b[1] = this.p - ((double) this.q.p());
        } else {
            this.b[1] = b2;
        }
        if (z2 && z) {
            return true;
        }
        return false;
    }
}
