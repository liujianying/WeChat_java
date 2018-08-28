package com.tencent.mm.modelgeo;

import android.os.Bundle;
import com.tencent.mm.modelgeo.c.1;

class c$1$1 implements Runnable {
    final /* synthetic */ double dSA;
    final /* synthetic */ double dSB;
    final /* synthetic */ 1 dSC;
    final /* synthetic */ boolean dSv;
    final /* synthetic */ double dSw;
    final /* synthetic */ double dSx;
    final /* synthetic */ int dSy;
    final /* synthetic */ double dSz;

    c$1$1(1 1, boolean z, double d, double d2, int i, double d3, double d4, double d5) {
        this.dSC = 1;
        this.dSv = z;
        this.dSw = d;
        this.dSx = d2;
        this.dSy = i;
        this.dSz = d3;
        this.dSA = d4;
        this.dSB = d5;
    }

    public final void run() {
        Bundle bundle = new Bundle();
        bundle.putString("indoor_building_floor", this.dSC.dSu.dSo);
        bundle.putString("indoor_building_id", this.dSC.dSu.dSn);
        bundle.putInt("indoor_building_type", this.dSC.dSu.dSp);
        c.a(this.dSC.dSu, this.dSv, this.dSw, this.dSx, this.dSy, this.dSz, this.dSA, this.dSB, bundle);
    }
}
