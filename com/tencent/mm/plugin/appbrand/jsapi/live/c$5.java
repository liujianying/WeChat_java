package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.live.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.live.c.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ITXLivePushListener;
import org.json.JSONException;
import org.json.JSONObject;

class c$5 implements ITXLivePushListener {
    final /* synthetic */ p fJO;
    final /* synthetic */ int fKG;
    final /* synthetic */ c fRO;

    c$5(c cVar, int i, p pVar) {
        this.fRO = cVar;
        this.fKG = i;
        this.fJO = pVar;
    }

    public final void onPushEvent(int i, Bundle bundle) {
        x.i("MicroMsg.JsApiInsertLivePusher", "onPushEvent errCode:%d", new Object[]{Integer.valueOf(i)});
        b bVar = new b((byte) 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", i);
            jSONObject.put("errMsg", bundle.getString("EVT_MSG"));
            jSONObject.put("livePusherId", this.fKG);
        } catch (JSONException e) {
        }
        h aC = bVar.aC(this.fJO.mAppId, this.fJO.hashCode());
        aC.mData = jSONObject.toString();
        aC.ahM();
    }

    public final void onNetStatus(Bundle bundle) {
        a aVar = new a((byte) 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("livePusherId", this.fKG);
            JSONObject jSONObject2 = new JSONObject();
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    jSONObject2.put(str, bundle.get(str));
                }
            }
            jSONObject.put("info", jSONObject2);
        } catch (JSONException e) {
        }
        h aC = aVar.aC(this.fJO.mAppId, this.fJO.hashCode());
        aC.mData = jSONObject.toString();
        aC.ahM();
    }
}
