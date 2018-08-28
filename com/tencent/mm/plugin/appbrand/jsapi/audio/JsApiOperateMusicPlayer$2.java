package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.3;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiOperateMusicPlayer$2 extends b {
    final /* synthetic */ l fCl;
    final /* synthetic */ u.b fIk;
    final /* synthetic */ JsApiOperateMusicPlayer fIq;

    JsApiOperateMusicPlayer$2(JsApiOperateMusicPlayer jsApiOperateMusicPlayer, u.b bVar, l lVar) {
        this.fIq = jsApiOperateMusicPlayer;
        this.fIk = bVar;
        this.fCl = lVar;
    }

    public final void a(c cVar) {
        String string = this.fIk.getString("appId", "");
        this.fIk.getInt("pkgType", 0);
        switch (3.fjK[cVar.ordinal()]) {
            case 1:
            case 2:
                int i = this.fCl.fdO.fcE.scene;
                a.anT();
                if (i != 1023) {
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
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void onDestroy() {
        x.d("MicroMsg.JsApiOperateMusicPlayer", "onDestroy");
        String string = this.fIk.getString("appId", "");
        this.fIk.getInt("pkgType", 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operationType", "stop");
        } catch (JSONException e) {
        }
        OperateMusicPlayer operateMusicPlayer = new OperateMusicPlayer(this.fIq, this.fCl, OperateMusicPlayer.a(this.fIq.fIp));
        operateMusicPlayer.bVc = jSONObject.toString();
        operateMusicPlayer.bPS = string;
        operateMusicPlayer.action = -1;
        operateMusicPlayer.fvX = this.fIk;
        AppBrandMainProcessService.b(operateMusicPlayer);
    }
}
