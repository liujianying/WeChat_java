package com.tencent.mm.modelgeo;

import android.os.Bundle;
import com.tencent.mm.modelgeo.c.2;

class c$2$1 implements Runnable {
    final /* synthetic */ double dSA;
    final /* synthetic */ double dSB;
    final /* synthetic */ 2 dSD;
    final /* synthetic */ boolean dSv;
    final /* synthetic */ double dSw;
    final /* synthetic */ double dSx;
    final /* synthetic */ int dSy;
    final /* synthetic */ double dSz;

    c$2$1(2 2, boolean z, double d, double d2, int i, double d3, double d4, double d5) {
        this.dSD = 2;
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
        bundle.putString("indoor_building_floor", this.dSD.dSu.dSo);
        bundle.putString("indoor_building_id", this.dSD.dSu.dSn);
        bundle.putInt("indoor_building_type", this.dSD.dSu.dSp);
        c.a(this.dSD.dSu, this.dSv, this.dSw, this.dSx, this.dSy, this.dSz, this.dSA, this.dSB, bundle);
    }
}
