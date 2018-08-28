package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.g.a.s;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.media.a.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.a;
import com.tencent.mm.z.b;
import com.tencent.mm.z.d;

class j$c extends a {
    public String appId = "";
    public String bGW = "";
    public String dGC = "";
    public int dGs = 0;
    public boolean dGu = false;
    public boolean dGv = false;
    public double dGx;
    private e fFF;
    public l fFa;
    public int fFd;
    public String fHW;
    public boolean fHX = false;
    public String ffK;
    public String processName = "";

    public j$c(e eVar, l lVar, int i) {
        this.fFF = eVar;
        this.fFa = lVar;
        this.fFd = i;
    }

    public final void ahW() {
        x.i("MicroMsg.Audio.JsApiSetAudioState", "SetAudioTask runTask");
        this.fHX = false;
        this.fHW = "";
        a jE = b.jE(this.bGW);
        a aVar = new a();
        aVar.bGW = this.bGW;
        aVar.cfD = this.dGC;
        aVar.dGs = this.dGs;
        aVar.dGt = this.dGs;
        aVar.dGu = this.dGu;
        aVar.dGv = this.dGv;
        aVar.processName = this.processName;
        aVar.dGx = this.dGx;
        aVar.appId = this.appId;
        aVar.fromScene = 0;
        s sVar;
        if (jE != null && this.dGC.equalsIgnoreCase(jE.cfD) && b.jD(this.bGW)) {
            x.i("MicroMsg.Audio.JsApiSetAudioState", "same src is playing audio, not to start again, but setAudioParam to update");
            x.i("MicroMsg.AudioPlayerHelper", "setAudioParam, audioId:%s, src:%s", new Object[]{aVar.bGW, aVar.cfD});
            sVar = new s();
            sVar.bGU.action = 18;
            sVar.bGU.bGW = aVar.bGW;
            sVar.bGU.bGY = aVar;
            com.tencent.mm.sdk.b.a.sFg.m(sVar);
            if (!sVar.bGV.bGZ) {
                this.fHX = true;
                this.fHW = "not to set audio param, the audioId is err";
                x.e("MicroMsg.Audio.JsApiSetAudioState", "not to set audio param, the audioId is err");
            }
            En();
            return;
        }
        x.i("MicroMsg.Audio.JsApiSetAudioState", "appId:%s, audioId:%s, src:%s, startTime:%d", new Object[]{this.appId, this.bGW, this.dGC, Integer.valueOf(this.dGs)});
        if (this.dGC.startsWith("wxfile://")) {
            aVar.filePath = this.dGC.substring(9);
            x.i("MicroMsg.Audio.JsApiSetAudioState", "filePath:%s", new Object[]{aVar.filePath});
        } else if (!(this.dGC.startsWith("http://") || this.dGC.startsWith("https://"))) {
            d bD = f.bD(this.dGC, this.ffK);
            if (bD.isOpen()) {
                aVar.filePath = this.dGC;
                aVar.dGy = bD;
            } else {
                this.fHX = true;
                this.fHW = "the file not exist for src";
                x.e("MicroMsg.Audio.JsApiSetAudioState", "the wxa audioDataSource not found for src %s", new Object[]{this.dGC});
                En();
                return;
            }
        }
        En();
        if (!this.fHX) {
            x.d("MicroMsg.AudioPlayerHelper", "startAudio, audioId:%s", new Object[]{aVar.bGW});
            sVar = new s();
            sVar.bGU.action = 0;
            sVar.bGU.bGW = aVar.bGW;
            sVar.bGU.bGY = aVar;
            com.tencent.mm.sdk.b.a.sFg.m(sVar);
        }
    }

    public final void En() {
        super.En();
        if (this.fFa == null) {
            x.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        } else if (this.fHX) {
            this.fFa.E(this.fFd, this.fFF.f("fail:" + this.fHW, null));
        } else {
            this.fFa.E(this.fFd, this.fFF.f("ok", null));
        }
    }
}
