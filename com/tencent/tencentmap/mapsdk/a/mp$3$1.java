package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.a.mp.3;

class mp$3$1 implements Runnable {
    final /* synthetic */ float a;
    final /* synthetic */ GeoPoint b;
    final /* synthetic */ 3 c;

    mp$3$1(3 3, float f, GeoPoint geoPoint) {
        this.c = 3;
        this.a = f;
        this.b = geoPoint;
    }

    public void run() {
        double d = 0.0d;
        if (mp.a(this.c.d) != null) {
            if (this.c.a) {
                double e = (((double) ((int) this.c.d.e())) - (Math.log((double) (1.0f / this.a)) / Math.log(2.0d))) - 2.0d;
                if (e >= 0.0d) {
                    d = e;
                }
                kp kpVar = new kp(10000);
                kpVar.c(this.b.getLatitudeE6(), this.b.getLongitudeE6());
                kpVar.a((float) d);
                kpVar.a(mp.b(this.c.d));
                kpVar.a(this.c.b);
                kpVar.a(this.c.c);
                mp.a(this.c.d).getMap().a(kpVar);
                return;
            }
            mp.a(this.c.d).getMap().b(this.b);
            mp.a(this.c.d).getMap().c(this.a);
        }
    }
}
