package com.tencent.mm.plugin.appbrand.r.b;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mm.plugin.appbrand.r.b.b.a;

class a$a implements TencentLocationListener {
    final /* synthetic */ a gCu;

    private a$a(a aVar) {
        this.gCu = aVar;
    }

    /* synthetic */ a$a(a aVar, byte b) {
        this(aVar);
    }

    public final void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
        b[] bVarArr;
        synchronized (this.gCu.gCt) {
            bVarArr = (b[]) this.gCu.gCt.toArray(new b[0]);
        }
        int length = bVarArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < length) {
                b bVar = bVarArr[i3];
                if (bVar != null) {
                    bVar.a(tencentLocation.getLatitude(), tencentLocation.getLongitude(), a.vU(tencentLocation.getProvider()), (double) tencentLocation.getSpeed(), (double) tencentLocation.getAccuracy(), tencentLocation.getAltitude());
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public final void onStatusUpdate(String str, int i, String str2) {
    }
}
