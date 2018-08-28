package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.a.mp.a;

class mp$b implements a {
    final /* synthetic */ mp a;
    private boolean b = false;

    public mp$b(mp mpVar, boolean z) {
        this.a = mpVar;
        this.b = z;
    }

    public void a() {
        if (mp.a(this.a).A != 0 && mp.a(this.a).B != 0) {
            mp.a(this.a).setOnSurfaceChangedListener(null);
            if (mp.a(this.a).t != null && mp.a(this.a).u != null) {
                float a;
                GeoPoint geoPoint = new GeoPoint();
                if (mp.a(this.a).w == 0 && mp.a(this.a).x == 0 && mp.a(this.a).y == 0 && mp.a(this.a).z == 0) {
                    a = this.a.a(0, 0, 0, 0, mp.a(this.a).t, mp.a(this.a).u, geoPoint);
                } else {
                    a = this.a.a(mp.a(this.a).w, mp.a(this.a).x, mp.a(this.a).y, mp.a(this.a).z, mp.a(this.a).t, mp.a(this.a).u, geoPoint);
                }
                ac.a aVar = mp.a(this.a).C;
                int latitudeE6 = geoPoint.getLatitudeE6();
                int longitudeE6 = geoPoint.getLongitudeE6();
                if (this.b) {
                    kp kpVar = new kp(10000);
                    kpVar.c(0.0f);
                    kpVar.d(0.0f);
                    kpVar.c(latitudeE6, longitudeE6);
                    kpVar.a(a);
                    kpVar.a(mp.b(this.a));
                    kpVar.a(aVar);
                    mp.a(this.a).getMap().a(kpVar);
                } else {
                    mp.a(this.a).getMap().b(0.0f);
                    mp.a(this.a).getMap().a(0.0f);
                    mp.a(this.a).getMap().a(latitudeE6, longitudeE6);
                    mp.a(this.a, a, false, 0, null);
                }
                mp.a(this.a).t = null;
                mp.a(this.a).u = null;
                mp.a(this.a).w = 0;
                mp.a(this.a).x = 0;
                mp.a(this.a).y = 0;
                mp.a(this.a).z = 0;
                mp.a(this.a).C = null;
            }
        }
    }
}
