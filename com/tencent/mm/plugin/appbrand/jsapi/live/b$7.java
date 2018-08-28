package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.live.b.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ITXLivePlayListener;
import org.json.JSONException;
import org.json.JSONObject;

class b$7 implements ITXLivePlayListener {
    final /* synthetic */ p fJO;
    final /* synthetic */ int fKG;
    final /* synthetic */ b fRI;

    b$7(b bVar, int i, p pVar) {
        this.fRI = bVar;
        this.fKG = i;
        this.fJO = pVar;
    }

    public final void onPlayEvent(int i, Bundle bundle) {
        x.i("MicroMsg.JsApiInsertLivePlayer", "onPlayEvent errCode:%d", new Object[]{Integer.valueOf(i)});
        b$c b_c = new b$c();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", i);
            jSONObject.put("errMsg", bundle.getString("EVT_MSG"));
            jSONObject.put("livePlayerId", this.fKG);
        } catch (JSONException e) {
        }
        h aC = b_c.aC(this.fJO.mAppId, this.fJO.hashCode());
        aC.mData = jSONObject.toString();
        aC.ahM();
    }

    public final void onNetStatus(Bundle bundle) {
        b bVar = new b((byte) 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("livePlayerId", this.fKG);
            JSONObject jSONObject2 = new JSONObject();
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    jSONObject2.put(str, bundle.get(str));
                }
            }
            jSONObject.put("info", jSONObject2);
        } catch (JSONException e) {
        }
        h aC = bVar.aC(this.fJO.mAppId, this.fJO.hashCode());
        aC.mData = jSONObject.toString();
        aC.ahM();
    }
}
