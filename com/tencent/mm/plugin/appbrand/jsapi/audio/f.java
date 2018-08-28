package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public class f extends a {
    public static final int CTRL_INDEX = 293;
    public static final String NAME = "getAudioState";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState data is null");
            lVar.E(i, f("fail:data is null", null));
            return;
        }
        Object optString = jSONObject.optString("audioId");
        if (TextUtils.isEmpty(optString)) {
            x.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState audioId is empty");
            lVar.E(i, f("fail:audioId is empty", null));
            return;
        }
        a aVar = new a(this, lVar, i);
        aVar.appId = lVar.mAppId;
        aVar.bGW = optString;
        aVar.ahT();
    }
}
