package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.modelgeo.a.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class g$51 implements b {
    final /* synthetic */ g qiK;
    final /* synthetic */ String qjq;

    g$51(g gVar, String str) {
        this.qiK = gVar;
        this.qjq = str;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        return false;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, Bundle bundle) {
        if (!z) {
            return true;
        }
        x.v("MicroMsg.MsgHandler", "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2)});
        if (g.x(this.qiK) != null) {
            g.x(this.qiK).c(g.y(this.qiK));
        }
        if (g.y(this.qiK) == null) {
            x.w("MicroMsg.MsgHandler", "already callback");
            return false;
        }
        g.z(this.qiK);
        Map hashMap = new HashMap();
        hashMap.put("longitude", Float.valueOf(f));
        g.b(this.qiK, String.valueOf(f));
        hashMap.put("latitude", Float.valueOf(f2));
        g.c(this.qiK, String.valueOf(f2));
        hashMap.put("speed", Double.valueOf(d));
        hashMap.put("accuracy", Double.valueOf(d2));
        hashMap.put("type", this.qjq);
        if (bundle != null) {
            hashMap.put("indoor_building_id", bundle.getString("indoor_building_id"));
            hashMap.put("indoor_building_floor", bundle.getString("indoor_building_floor"));
            hashMap.put("indoor_building_type", Integer.valueOf(bundle.getInt("indoor_building_type")));
        }
        g.a(this.qiK, g.k(this.qiK), "geo_location:ok", hashMap);
        return false;
    }
}
