package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiSetBackgroundAudioState$1 implements f {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiSetBackgroundAudioState fIT;
    final /* synthetic */ b fIk;

    JsApiSetBackgroundAudioState$1(JsApiSetBackgroundAudioState jsApiSetBackgroundAudioState, b bVar, l lVar, int i) {
        this.fIT = jsApiSetBackgroundAudioState;
        this.fIk = bVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void an(String str, int i) {
        String string = this.fIk.getString("appId", "");
        int i2 = this.fIk.getInt("pkgType", 0);
        if ((!string.equals(str) || i2 != i) && this.fIk.ie("setBackgroundAudioState#isPlaying") && e.qo(string) != a.fca) {
            x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onStickyBannerChanged, pause the music");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("operationType", "pause");
            } catch (JSONException e) {
            }
            SetBackgroundAudioStateTask setBackgroundAudioStateTask = new SetBackgroundAudioStateTask(this.fIT, this.fCl, this.doP);
            setBackgroundAudioStateTask.fIo = jSONObject.toString();
            setBackgroundAudioStateTask.appId = string;
            AppBrandMainProcessService.a(setBackgroundAudioStateTask);
        }
    }
}
