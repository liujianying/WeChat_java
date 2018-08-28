package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 103;
    public static final String NAME = "chooseLocation";
    int fFw = 0;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 8);
        MMActivity c = c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
            x.e("MicroMsg.JsApiChooseLocation", "mmActivity is null, invoke fail!");
            return;
        }
        this.fFw = i;
        c.geJ = new 1(this, lVar);
        d.b(c, "location", ".ui.RedirectUI", intent, 1);
    }
}
