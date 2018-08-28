package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.gl.JNICallback.e;
import com.tencent.tencentmap.mapsdk.a.ac.f;
import com.tencent.tencentmap.mapsdk.a.ic.a;
import com.tencent.tencentmap.mapsdk.a.ic.c;
import java.util.ArrayList;
import java.util.List;

public class oj implements e, he {
    ov a = null;
    private ks b = null;
    private f c = null;
    private Handler d = new Handler();
    private boolean e = false;

    public oj(ks ksVar) {
        this.b = ksVar;
        if (ksVar != null && ksVar.getMap() != null) {
            com.tencent.map.lib.f map = ksVar.getMap();
            map.a(this);
            map.a(this);
        }
    }

    public boolean a() {
        return this.e;
    }

    public void a(f fVar) {
        this.c = fVar;
    }

    public void z() {
        int i = 0;
        if (this.b != null && this.b.getMap() != null) {
            com.tencent.map.lib.f map = this.b.getMap();
            String c = map.c(new GeoPoint(0, 0));
            String[] x = map.x();
            int w = map.w();
            if (x == null || x.length > w) {
                i = w;
            }
            this.d.post(new 1(this, c, x, i));
        }
    }

    private void a(String str, String[] strArr, int i) {
        int i2 = 0;
        if (this.b != null) {
            com.tencent.map.lib.f map = this.b.getMap();
            int c = map.c();
            if (strArr == null || strArr.length <= 0 || i < 0 || c < 16) {
                map.e(Math.min(a.a, c));
                if (this.e) {
                    this.e = false;
                    this.a = null;
                    if (this.c != null) {
                        this.c.b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (!(this.c == null || this.e)) {
                this.e = true;
                this.c.a();
            }
            map.e(22);
            if (this.c != null) {
                List arrayList = new ArrayList();
                if (strArr != null) {
                    c = strArr.length;
                    while (i2 < c) {
                        arrayList.add(new ow(strArr[i2]));
                        i2++;
                    }
                }
                try {
                    if (this.a != null && this.a.a().equals(str) && this.a.c() == i) {
                        return;
                    }
                } catch (Exception e) {
                }
                this.a = new ov(str, arrayList, i);
                this.c.a(this.a);
            }
        }
    }

    public void a(c cVar) {
        if (this.b != null && this.b.getMap() != null && this.b.getIndoorFloorControlManager() != null) {
            if (this.b.getMap().h() < 18 || !this.e) {
                this.b.getIndoorFloorControlManager().a(false);
            } else {
                this.b.getIndoorFloorControlManager().a(true);
            }
        }
    }
}
