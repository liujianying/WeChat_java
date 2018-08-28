package com.tencent.tencentmap.mapsdk.a;

import android.location.Location;
import com.tencent.tencentmap.mapsdk.a.ni.a;

class ac$1 implements a {
    final /* synthetic */ ac a;

    ac$1(ac acVar) {
        this.a = acVar;
    }

    public void a() {
        this.a.c(true);
        Location k = this.a.k();
        if (k != null) {
            this.a.b(y.a(new ox(k.getLatitude(), k.getLongitude())));
        }
    }
}
