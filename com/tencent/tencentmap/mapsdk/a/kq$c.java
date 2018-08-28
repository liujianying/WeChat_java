package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.util.StringUtil;
import java.lang.ref.WeakReference;

class kq$c extends ko {
    private final WeakReference<kq> a;

    public kq$c(kq kqVar) {
        this.a = new WeakReference(kqVar);
    }

    public Bitmap a(String str) {
        String b;
        Bitmap a;
        int c = c(str);
        if (c < 0) {
            b = b(str);
        } else {
            b = Integer.toString(c);
        }
        Bitmap a2 = hs.a(str);
        if (a2 == null) {
            a = kh.u.a(str);
        } else {
            a = a2;
        }
        if (this.a == null || this.a.get() == null || a != null) {
            return a;
        }
        if (c < 0) {
            try {
                a = kq.a((kq) this.a.get(), ((kq) this.a.get()).getContext(), b);
            } catch (OutOfMemoryError e) {
                return a;
            }
        }
        a = kh.a(((kq) this.a.get()).getContext(), c);
        if (a == null || StringUtil.isEmpty(str)) {
            return a;
        }
        if (str.equals("poi_icon.png") || str.equals("poi_icon_navi.png") || str.equals("poi_icon_dark.png") || str.equals("poi_icon_sat.png") || str.equals("poi_icon_indoor.png")) {
            return jz.a(a, kq.c((kq) this.a.get()));
        }
        if (!str.startsWith("mapcfg_") || str.equals("mapcfg_window.png")) {
            return a;
        }
        return jz.a(a, kq.c((kq) this.a.get()));
    }

    public String a(GeoPoint geoPoint) {
        return null;
    }
}
