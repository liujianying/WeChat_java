package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.media.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class h extends a {
    public static final int CTRL_INDEX = 297;
    public static final String NAME = "operateAudio";
    private j.a fIg;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (!d.fHU) {
            x.e("MicroMsg.Audio.JsApiOperateAudio", "can't do operateAudio, App is paused or background");
            lVar.E(i, f("fail:App is paused or background", null));
        } else if (jSONObject == null) {
            x.e("MicroMsg.Audio.JsApiOperateAudio", "operateAudio data is null");
            lVar.E(i, f("fail:data is null", null));
        } else {
            x.i("MicroMsg.Audio.JsApiOperateAudio", "operateAudio appId:%s, data:%s", new Object[]{lVar.mAppId, jSONObject.toString()});
            String optString = jSONObject.optString("audioId");
            int optInt = jSONObject.optInt("currentTime", 0);
            Object optString2 = jSONObject.optString("operationType");
            if (TextUtils.isEmpty(optString)) {
                x.e("MicroMsg.Audio.JsApiOperateAudio", "audioId is empty");
                lVar.E(i, f("fail:audioId is empty", null));
            } else if (TextUtils.isEmpty(optString2)) {
                x.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is empty");
                lVar.E(i, f("fail:operationType is empty", null));
            } else {
                if (this.fIg == null) {
                    this.fIg = new j.a(this, lVar, i);
                }
                this.fIg.appId = lVar.mAppId;
                this.fIg.ahT();
                a aVar = new a(this, lVar, i);
                aVar.appId = lVar.mAppId;
                aVar.bGW = optString;
                aVar.bGX = optInt;
                aVar.fIh = optString2;
                c ur = com.tencent.mm.plugin.appbrand.media.a.a.ur(optString);
                if (ur != null) {
                    aVar.fIi = ur.fIi;
                    aVar.ffK = ur.ffK;
                    aVar.dGC = ur.dGC;
                }
                aVar.processName = ad.getProcessName();
                aVar.ahT();
            }
        }
    }
}
