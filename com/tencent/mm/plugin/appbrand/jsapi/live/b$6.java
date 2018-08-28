package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.live.b.a;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONException;
import org.json.JSONObject;

class b$6 implements AppBrandLivePlayerView$b {
    final /* synthetic */ p fJO;
    final /* synthetic */ int fKG;
    final /* synthetic */ b fRI;

    b$6(b bVar, int i, p pVar) {
        this.fRI = bVar;
        this.fKG = i;
        this.fJO = pVar;
    }

    public final void e(boolean z, int i) {
        a aVar = new a((byte) 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fullScreen", z);
            jSONObject.put("direction", i);
            jSONObject.put("livePlayerId", this.fKG);
        } catch (JSONException e) {
        }
        h aC = aVar.aC(this.fJO.mAppId, this.fJO.hashCode());
        aC.mData = jSONObject.toString();
        aC.ahM();
    }
}
