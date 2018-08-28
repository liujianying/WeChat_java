package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.appbrand.appusage.j.c.1;
import com.tencent.mm.sdk.platformtools.x;

class j$c$1$1 implements a {
    final /* synthetic */ double dSA;
    final /* synthetic */ float flW;
    final /* synthetic */ float flX;
    final /* synthetic */ 1 flY;

    j$c$1$1(1 1, float f, float f2, double d) {
        this.flY = 1;
        this.flW = f;
        this.flX = f2;
        this.dSA = d;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.d("MicroMsg.AppBrandPushNewOrRedDotLogic", "locationReport, errType %d, errCode %d, errMsg %s, longitude %f, latitude %f, accuracy %f", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Float.valueOf(this.flW), Float.valueOf(this.flX), Double.valueOf(this.dSA)});
        return 0;
    }
}
