package com.tencent.mm.av;

import com.tencent.map.swlocation.api.LocationUpdateListener;
import com.tencent.mm.sdk.platformtools.x;

class b$5 implements LocationUpdateListener {
    final /* synthetic */ b eel;

    b$5(b bVar) {
        this.eel = bVar;
    }

    public final void onLocationUpdate(double d, double d2, int i, int i2, long j) {
        x.d("MicroMsg.SenseWhereHelper", "onLocationUpdate latitude[%f] longitude[%f] error[%d] floor[%d] buildingId[%d]", new Object[]{Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)});
    }
}
