package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiStartPlayVoice extends a {
    public static final int CTRL_INDEX = 33;
    public static final String NAME = "playVoice";
    public static String fIW = null;
    private StartPlayVoice fIX;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String aG = bi.aG(jSONObject.optString("filePath", null), jSONObject.optString("localId"));
        x.i("MicroMsg.JsApiStartPlayVoice", "doPlayVoice, appId : %s, localId : %s", new Object[]{lVar.mAppId, aG});
        if (bi.oW(aG)) {
            lVar.E(i, f("fail_missing arguments", null));
            return;
        }
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(lVar.mAppId, aG);
        p d = d(lVar);
        if (itemByLocalId == null || bi.oW(itemByLocalId.dDG) || d == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        b v = u.Hx().v("JsApi@" + d.hashCode(), true);
        d dVar = (d) v.get("onBackgroundListener", null);
        if (dVar == null) {
            dVar = new 1(this, d);
            v.p("onBackgroundListener", dVar);
        }
        d.a(dVar);
        if (((e) v.get("onDestroyListener", null)) == null) {
            2 2 = new 2(this, d);
            v.p("onDestroyListener", 2);
            d.a(2);
        }
        if (this.fIX == null) {
            this.fIX = new StartPlayVoice(this, lVar, i);
        }
        if (fIW != null) {
            Map hashMap = new HashMap();
            hashMap.put("localId", this.fIX.bNH);
            lVar.E(StartPlayVoice.a(this.fIX), f("fail", hashMap));
            return;
        }
        StartPlayVoice.a(this.fIX, this);
        StartPlayVoice.a(this.fIX, lVar);
        StartPlayVoice.a(this.fIX, i);
        this.fIX.bNH = aG;
        this.fIX.filePath = itemByLocalId.dDG;
        AppBrandMainProcessService.a(this.fIX);
        fIW = aG;
    }
}
