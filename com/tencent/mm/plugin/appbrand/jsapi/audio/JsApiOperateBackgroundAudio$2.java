package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiOperateBackgroundAudio$2 extends b {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ u.b fIk;
    final /* synthetic */ JsApiOperateBackgroundAudio fIl;

    JsApiOperateBackgroundAudio$2(JsApiOperateBackgroundAudio jsApiOperateBackgroundAudio, u.b bVar, l lVar, int i) {
        this.fIl = jsApiOperateBackgroundAudio;
        this.fIk = bVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void onDestroy() {
        x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onDestroy, appId:%s", new Object[]{this.fIk.getString("appId", "")});
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operationType", "stop");
        } catch (JSONException e) {
        }
        MainProcessTask jsApiOperateBackgroundAudio$OperateBackgroundAudioTask = new JsApiOperateBackgroundAudio$OperateBackgroundAudioTask(this.fIl, this.fCl, this.doP);
        jsApiOperateBackgroundAudio$OperateBackgroundAudioTask.fIo = jSONObject.toString();
        jsApiOperateBackgroundAudio$OperateBackgroundAudioTask.appId = r0;
        AppBrandMainProcessService.b(jsApiOperateBackgroundAudio$OperateBackgroundAudioTask);
    }
}
