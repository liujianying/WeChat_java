package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.tencentmap.mapsdk.a.hv.a;
import javax.microedition.khronos.opengles.GL10;

class hq$10 implements a {
    final /* synthetic */ boolean a;
    final /* synthetic */ float b;
    final /* synthetic */ float c;
    final /* synthetic */ hq d;

    hq$10(hq hqVar, boolean z, float f, float f2) {
        this.d = hqVar;
        this.a = z;
        this.b = f;
        this.c = f2;
    }

    public void a(GL10 gl10) {
        if (this.a) {
            hq.b(this.d).nativeSetScreenCenterOffset(hq.a(this.d), this.b, this.c, true);
            return;
        }
        hh d = hq.c(this.d).d();
        DoublePoint b = d.b(this.d.q());
        hq.b(this.d).nativeSetScreenCenterOffset(hq.a(this.d), this.b, this.c, false);
        DoublePoint b2 = d.b(this.d.q());
        hq.b(this.d).nativeSetCenter(hq.a(this.d), d.a(new DoublePoint((b2.x - b.x) + b2.x, (b2.y - b.y) + b2.y)), false);
    }
}
