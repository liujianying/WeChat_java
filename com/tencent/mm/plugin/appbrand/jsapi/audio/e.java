package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 290;
    public static final String NAME = "destroyAudioInstance";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance fail, data is null");
            lVar.E(i, f("fail:data is null", null));
            return;
        }
        x.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance data:%s", new Object[]{jSONObject.toString()});
        Object optString = jSONObject.optString("audioId");
        if (TextUtils.isEmpty(optString)) {
            x.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "audioId is empty");
            lVar.E(i, f("fail:audioId is empty", null));
            return;
        }
        a aVar = new a(this, lVar, i);
        aVar.appId = lVar.mAppId;
        aVar.bGW = optString;
        aVar.ahT();
    }
}
