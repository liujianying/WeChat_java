package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.g.a.s;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class e$a extends a {
    public String appId = "";
    public String bGW = "";
    private e fFF;
    public l fFa;
    public int fFd;
    public boolean fHX = false;

    public e$a(e eVar, l lVar, int i) {
        this.fFF = eVar;
        this.fFa = lVar;
        this.fFd = i;
    }

    public final void ahW() {
        x.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runTask");
        x.i("MicroMsg.AudioPlayerHelper", "destroyAudio, audioId:%s", new Object[]{this.bGW});
        s sVar = new s();
        sVar.bGU.action = 5;
        sVar.bGU.bGW = r0;
        a.sFg.m(sVar);
        this.fHX = sVar.bGV.bGZ;
        En();
    }

    public final void En() {
        super.En();
        x.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "callback");
        if (this.fFa == null) {
            x.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "server is null");
        } else if (this.fHX) {
            this.fFa.E(this.fFd, this.fFF.f("fail", null));
        } else {
            this.fFa.E(this.fFd, this.fFF.f("ok", null));
        }
    }
}
