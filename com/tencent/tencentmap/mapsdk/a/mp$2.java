package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.a.kp.a;

class mp$2 implements a {
    final /* synthetic */ mp a;

    mp$2(mp mpVar) {
        this.a = mpVar;
    }

    public int b() {
        if (mp.a(this.a) == null) {
            return 0;
        }
        return ne.a(mp.a(this.a).getMap().d());
    }

    public GeoPoint c() {
        if (mp.a(this.a) == null) {
            return null;
        }
        return mp.a(this.a).getMap().f();
    }

    public float d() {
        if (mp.a(this.a) == null) {
            return 0.0f;
        }
        return mp.a(this.a).getMap().p();
    }

    public float e() {
        if (mp.a(this.a) == null) {
            return 0.0f;
        }
        return mp.a(this.a).getMap().q();
    }

    public float a() {
        if (mp.a(this.a) == null) {
            return 0.0f;
        }
        return this.a.o();
    }

    public GeoPoint f() {
        if (mp.a(this.a) == null) {
            return null;
        }
        return mp.a(this.a).getNaviCenter();
    }

    public void a(Runnable runnable) {
        if (runnable != null && mp.a(this.a) != null && mp.a(this.a).s != null) {
            mp.a(this.a).s.postDelayed(runnable, 100);
        }
    }
}
