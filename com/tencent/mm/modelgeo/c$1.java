package com.tencent.mm.modelgeo;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class c$1 extends e {
    final /* synthetic */ c dSu;

    c$1(c cVar) {
        this.dSu = cVar;
    }

    public final void a(boolean z, double d, double d2, int i, double d3, double d4, double d5, String str, String str2, int i2) {
        c.a(this.dSu, z, d, d2, d4, true);
        if (z) {
            this.dSu.dSi = d;
            this.dSu.dSj = d2;
            this.dSu.dSk = i;
            this.dSu.dSl = d3;
            this.dSu.dSm = d4;
            this.dSu.bhF = d5;
            this.dSu.dSn = str;
            this.dSu.dSo = str2;
            this.dSu.dSp = i2;
            this.dSu.dSf = System.currentTimeMillis();
            this.dSu.dSg = true;
            this.dSu.dSh = false;
            c.a(this.dSu, 67592);
        }
        x.d("MicroMsg.LocationGeo", "onGetLocation fLongitude: %f fLatitude:%f locType:%d %f:spped", Double.valueOf(d2), Double.valueOf(d), Integer.valueOf(i), Double.valueOf(d3));
        new ag(Looper.getMainLooper()).post(new 1(this, z, d, d2, i, d3, d4, d5));
    }
}
