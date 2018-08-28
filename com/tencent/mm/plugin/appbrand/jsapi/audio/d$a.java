package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.g.a.s;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class d$a extends a {
    public String appId = "";
    public String bGW = "";
    public int bWA = 0;
    public String fHW = "";

    public final void ahW() {
        x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "runTask flag:%d", new Object[]{Integer.valueOf(this.bWA)});
        this.fHW = "";
        s sVar;
        if (this.bWA == 0) {
            x.i("MicroMsg.AudioPlayerHelper", "createAudioPlayer, appId:%s, audioId:%s", new Object[]{this.appId, this.bGW});
            s sVar2 = new s();
            sVar2.bGU.action = 10;
            sVar2.bGU.appId = r0;
            sVar2.bGU.bGW = r1;
            a.sFg.m(sVar2);
            this.bGW = sVar2.bGU.bGW;
            x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "player audioId:%s", new Object[]{this.bGW});
            if (TextUtils.isEmpty(this.bGW)) {
                this.fHW = "fail to create audio instance";
            }
        } else if (this.bWA == 1) {
            x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "pauseAllAudioPlayer");
            x.i("MicroMsg.AudioPlayerHelper", "pauseAllAudioPlayer appId:%s", new Object[]{this.appId});
            sVar = new s();
            sVar.bGU.action = 12;
            sVar.bGU.appId = r0;
            a.sFg.m(sVar);
        } else if (this.bWA == 2) {
            x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "stopAllAudioPlayer");
            x.i("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayer appId:%s", new Object[]{this.appId});
            sVar = new s();
            sVar.bGU.action = 9;
            sVar.bGU.appId = r0;
            a.sFg.m(sVar);
            com.tencent.mm.plugin.appbrand.media.a.a.us(this.appId);
        }
        En();
    }

    public final void En() {
        super.En();
        if (this.bWA == 0) {
            if (TextUtils.isEmpty(this.bGW)) {
                x.e("MicroMsg.Audio.JsApiCreateAudioInstance", "create player failed");
            } else {
                x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "create player ok");
            }
        } else if (this.bWA != 1) {
            x.e("MicroMsg.Audio.JsApiCreateAudioInstance", "destroy audio instance end");
        }
    }
}
