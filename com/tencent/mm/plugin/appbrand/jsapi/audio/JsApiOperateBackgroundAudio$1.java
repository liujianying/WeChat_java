package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiOperateBackgroundAudio$1 implements f {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ b fIk;
    final /* synthetic */ JsApiOperateBackgroundAudio fIl;

    JsApiOperateBackgroundAudio$1(JsApiOperateBackgroundAudio jsApiOperateBackgroundAudio, b bVar, l lVar, int i) {
        this.fIl = jsApiOperateBackgroundAudio;
        this.fIk = bVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void an(String str, int i) {
        String string = this.fIk.getString("appId", "");
        int i2 = this.fIk.getInt("pkgType", 0);
        if ((!string.equals(str) || i2 != i) && this.fIk.ie("operateBackgroundAudio#isPlaying") && e.qo(string) != a.fca) {
            x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onStickyBannerChanged, pause the music");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("operationType", "pause");
            } catch (JSONException e) {
            }
            MainProcessTask jsApiOperateBackgroundAudio$OperateBackgroundAudioTask = new JsApiOperateBackgroundAudio$OperateBackgroundAudioTask(this.fIl, this.fCl, this.doP);
            jsApiOperateBackgroundAudio$OperateBackgroundAudioTask.fIo = jSONObject.toString();
            jsApiOperateBackgroundAudio$OperateBackgroundAudioTask.appId = string;
            AppBrandMainProcessService.a(jsApiOperateBackgroundAudio$OperateBackgroundAudioTask);
        }
    }
}
