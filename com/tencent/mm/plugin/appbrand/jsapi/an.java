package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.n.11;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class an extends a {
    public static final int CTRL_INDEX = 14;
    public static final String NAME = "navigateTo";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        int i2 = lVar.fdO.fcu.fqR;
        if (lVar.fdO.fcz.getPageCount() >= i2) {
            lVar.E(i, f("fail:page limit exceeded: " + i2, null));
            x.e("MicroMsg.JsApiNavigateTo", "page limit exceeded: " + i2);
            return;
        }
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (lVar.fdO.fcv.foP.rH(optString)) {
            lVar.E(i, f("fail:can not navigate to a tab bar page", null));
            return;
        }
        n nVar = lVar.fdO.fcz;
        nVar.runOnUiThread(new 11(nVar, optString));
        lVar.E(i, f("ok", null));
    }
}
