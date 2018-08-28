package com.tencent.mm.plugin.location.model;

import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements a$a {
    final /* synthetic */ i kCT;

    i$1(i iVar) {
        this.kCT = iVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return false;
        }
        if (!(this.kCT.kCP == -1000.0d || this.kCT.kCQ == -1000.0d)) {
            this.kCT.kCS = f.a(this.kCT.kCQ, this.kCT.kCP, (double) f, (double) f2, i, d);
        }
        this.kCT.kCP = (double) f2;
        this.kCT.kCQ = (double) f;
        if (this.kCT.kCO == 900.0d || this.kCT.kCN == 900.0d) {
            i iVar = this.kCT;
            i iVar2 = this.kCT;
            double i2 = f.i((double) f2, (double) f);
            iVar2.kCN = i2;
            iVar.kCO = i2;
        } else {
            this.kCT.kCO = this.kCT.kCN;
            this.kCT.kCN = f.i((double) f2, (double) f);
        }
        x.d("MicroMsg.OrientationSensorMgr", "onGetLocation, update headding, mCurrentHeading = %f, mPreviousHeading = %f mIsMove = %b", new Object[]{Double.valueOf(this.kCT.kCN), Double.valueOf(this.kCT.kCO), Boolean.valueOf(this.kCT.kCS)});
        return true;
    }
}
