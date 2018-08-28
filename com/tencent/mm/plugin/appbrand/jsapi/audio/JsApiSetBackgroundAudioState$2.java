package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiSetBackgroundAudioState$2 extends b {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiSetBackgroundAudioState fIT;
    final /* synthetic */ u.b fIk;

    JsApiSetBackgroundAudioState$2(JsApiSetBackgroundAudioState jsApiSetBackgroundAudioState, u.b bVar, l lVar, int i) {
        this.fIT = jsApiSetBackgroundAudioState;
        this.fIk = bVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void onDestroy() {
        x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", new Object[]{this.fIk.getString("appId", "")});
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operationType", "stop");
        } catch (JSONException e) {
        }
        JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask jsApiSetBackgroundAudioState$SetBackgroundAudioStateTask = new JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask(this.fIT, this.fCl, this.doP);
        jsApiSetBackgroundAudioState$SetBackgroundAudioStateTask.fIo = jSONObject.toString();
        jsApiSetBackgroundAudioState$SetBackgroundAudioStateTask.appId = r0;
        AppBrandMainProcessService.b(jsApiSetBackgroundAudioState$SetBackgroundAudioStateTask);
    }
}
