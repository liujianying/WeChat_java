package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.a.hv.a;
import javax.microedition.khronos.opengles.GL10;

class hq$6 implements a {
    final /* synthetic */ GeoPoint a;
    final /* synthetic */ boolean b;
    final /* synthetic */ hq c;

    hq$6(hq hqVar, GeoPoint geoPoint, boolean z) {
        this.c = hqVar;
        this.a = geoPoint;
        this.b = z;
    }

    public void a(GL10 gl10) {
        hq.b(this.c).nativeSetCenter(hq.a(this.c), this.a, this.b);
    }
}
