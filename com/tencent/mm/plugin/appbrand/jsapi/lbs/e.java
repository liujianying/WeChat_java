package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 38;
    public static final String NAME = "openLocation";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        int i2 = 0;
        try {
            float f = bi.getFloat(jSONObject.optString("latitude"), 0.0f);
            float f2 = bi.getFloat(jSONObject.optString("longitude"), 0.0f);
            String vS = c.vS(jSONObject.optString("name"));
            String vS2 = c.vS(jSONObject.optString("address"));
            try {
                i2 = bi.getInt(jSONObject.optString("scale"), 0);
            } catch (Exception e) {
            }
            Intent intent = new Intent();
            intent.putExtra("map_view_type", 7);
            intent.putExtra("kwebmap_slat", (double) f);
            intent.putExtra("kwebmap_lng", (double) f2);
            if (i2 > 0) {
                intent.putExtra("kwebmap_scale", i2);
            }
            intent.putExtra("kPoiName", vS);
            intent.putExtra("Kwebmap_locaion", vS2);
            MMActivity c = c(lVar);
            if (c == null) {
                lVar.E(i, f("fail", null));
                return;
            }
            d.b(c, "location", ".ui.RedirectUI", intent);
            lVar.E(i, f("ok", null));
        } catch (Exception e2) {
            lVar.E(i, f("invalid_coordinate", null));
        }
    }
}
