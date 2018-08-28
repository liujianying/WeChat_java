package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.mm.plugin.appbrand.game.k;
import com.tencent.mm.plugin.appbrand.game.page.d;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b extends n {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "setPreferredFramesPerSecond";

    public final String a(l lVar, JSONObject jSONObject) {
        if (jSONObject != null) {
            k kVar;
            if (lVar == null) {
                kVar = null;
            } else if (lVar.fdO == null || lVar.fdO.fcz == null || lVar.fdO.fcz.getCurrentPage() == null || lVar.fdO.fcz.getCurrentPage().getCurrentPageView() == null) {
                kVar = null;
            } else {
                p currentPageView = lVar.fdO.fcz.getCurrentPage().getCurrentPageView();
                kVar = (currentPageView == null || !(currentPageView instanceof d)) ? null : ((d) currentPageView).fCI;
            }
            if (kVar != null) {
                x.i("MicroMsg.JsApiSetPreferredFramesPerSecond", "GameRenderer.setFPS %d", new Object[]{Integer.valueOf(jSONObject.optInt("fps", 60))});
                kVar.setFps(Math.max(10, Math.min(60, r2)));
            }
        }
        return null;
    }
}
