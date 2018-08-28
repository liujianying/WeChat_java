package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.a.hv.a;
import com.tencent.tencentmap.mapsdk.a.ic.b;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

class gw$1 implements a {
    final /* synthetic */ List a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ Rect d;
    final /* synthetic */ int e;
    final /* synthetic */ hk f;
    final /* synthetic */ gw$a g;
    final /* synthetic */ gw h;

    gw$1(gw gwVar, List list, int i, int i2, Rect rect, int i3, hk hkVar, gw$a gw_a) {
        this.h = gwVar;
        this.a = list;
        this.b = i;
        this.c = i2;
        this.d = rect;
        this.e = i3;
        this.f = hkVar;
        this.g = gw_a;
    }

    public void a(GL10 gl10) {
        GeoPoint p = gw.a(this.h).p();
        float i = gw.a(this.h).i();
        GeoPoint geoPoint = null;
        float f = 4.0f;
        float o = gw.a(this.h).o();
        while (f >= o) {
            this.h.a(f);
            Rect a = gw.a(this.h, this.a, this.h);
            geoPoint = new GeoPoint(a.centerY(), a.centerX());
            this.h.a(geoPoint);
            GeoPoint geoPoint2 = new GeoPoint(a.top, a.left);
            GeoPoint geoPoint3 = new GeoPoint(a.bottom, a.right);
            DoublePoint b = this.h.b(geoPoint2);
            DoublePoint b2 = this.h.b(geoPoint3);
            Rect rect = new Rect();
            rect.left = (int) Math.min(b.x, b2.x);
            rect.right = (int) Math.max(b.x, b2.x);
            rect.top = (int) Math.min(b.y, b2.y);
            rect.bottom = (int) Math.max(b.y, b2.y);
            if (this.b < rect.width() || this.c < rect.height()) {
                f /= 1.01f;
            } else {
                if (!gw.b(this.h)) {
                    geoPoint = gw.a(this.h, geoPoint, this.d);
                } else if (gw.c(this.h)) {
                    b q = gw.a(this.h).q();
                    if (q != null) {
                        geoPoint = gw.a(this.h, geoPoint, q);
                    }
                }
                f = Math.max(o, f);
                if (this.e != 60) {
                    this.f.a(this.e);
                }
                this.h.a(p);
                this.h.a(i);
                if (this.g != null) {
                    try {
                        this.g.a(f, geoPoint, -1.0d);
                    } catch (Exception e) {
                    }
                }
            }
        }
        f = Math.max(o, f);
        if (this.e != 60) {
            this.f.a(this.e);
        }
        this.h.a(p);
        this.h.a(i);
        if (this.g != null) {
            try {
                this.g.a(f, geoPoint, -1.0d);
            } catch (Exception e2) {
            }
        }
    }
}
