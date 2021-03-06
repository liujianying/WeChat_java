package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class ap extends a {
    public static final int CTRL_INDEX = 59;
    public static final String NAME = "openCard";
    int fFw;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        Intent intent = new Intent();
        MMActivity c = c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
            x.e("MicroMsg.JsApiOpenCard", "mmActivity is null, invoke fail!");
            return;
        }
        String optString = jSONObject.optString("cardList");
        if (bi.oW(optString)) {
            lVar.E(i, f("fail", null));
            x.e("MicroMsg.JsApiOpenCard", "cardList is null, invoke fail!");
            return;
        }
        this.fFw = i;
        c.geJ = new 1(this, lVar);
        intent.putExtra("card_list", optString);
        intent.putExtra("key_from_scene", 26);
        AppBrandSysConfig appBrandSysConfig = lVar.fdO.fcu;
        if (!(appBrandSysConfig == null || appBrandSysConfig.frm == null)) {
            intent.putExtra("key_from_appbrand_type", appBrandSysConfig.frm.fih);
        }
        d.b(c, "card", ".ui.CardViewEntranceUI", intent, 1);
    }
}
