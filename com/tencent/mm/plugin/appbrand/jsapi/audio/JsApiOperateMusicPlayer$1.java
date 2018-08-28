package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiOperateMusicPlayer$1 implements f {
    final /* synthetic */ l fCl;
    final /* synthetic */ b fIk;
    final /* synthetic */ JsApiOperateMusicPlayer fIq;

    JsApiOperateMusicPlayer$1(JsApiOperateMusicPlayer jsApiOperateMusicPlayer, b bVar, l lVar) {
        this.fIq = jsApiOperateMusicPlayer;
        this.fIk = bVar;
        this.fCl = lVar;
    }

    public final void an(String str, int i) {
        String string = this.fIk.getString("appId", "");
        int i2 = this.fIk.getInt("pkgType", 0);
        if ((!string.equals(str) || i2 != i) && this.fIk.ie("Music#isPlaying") && e.qo(string) != a.fca) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("operationType", "pause");
            } catch (JSONException e) {
            }
            OperateMusicPlayer operateMusicPlayer = new OperateMusicPlayer(this.fIq, this.fCl, OperateMusicPlayer.a(this.fIq.fIp));
            operateMusicPlayer.bVc = jSONObject.toString();
            operateMusicPlayer.bPS = string;
            operateMusicPlayer.fvX = this.fIk;
            AppBrandMainProcessService.a(operateMusicPlayer);
        }
    }
}
