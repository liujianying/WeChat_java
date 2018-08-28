package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.g.a.s;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.a;
import com.tencent.mm.z.b;

final class h$a extends a {
    public String appId = "";
    public String bGW = "";
    public int bGX = 0;
    public String dGC = "";
    private e fFF;
    public l fFa;
    public int fFd;
    public String fHW;
    public boolean fHX = false;
    public String fIh = "";
    public String fIi;
    public String ffK;
    public String processName = "";

    public h$a(e eVar, l lVar, int i) {
        this.fFF = eVar;
        this.fFa = lVar;
        this.fFd = i;
    }

    public final void ahW() {
        x.i("MicroMsg.Audio.JsApiOperateAudio", "runTask operationType;%s", this.fIh);
        this.fHX = false;
        String str = this.fIh;
        s sVar;
        s sVar2;
        if (str.equalsIgnoreCase("play")) {
            a jE = b.jE(this.bGW);
            if (jE == null) {
                x.e("MicroMsg.Audio.JsApiOperateAudio", "play operate, playParam is null");
                jE = com.tencent.mm.plugin.appbrand.media.a.b.b(this.appId, this.bGW, this.dGC, this.fIi, this.ffK, this.processName);
            }
            x.d("MicroMsg.AudioPlayerHelper", "resumeAudio, audioId:%s", this.bGW);
            sVar = new s();
            sVar.bGU.action = 1;
            sVar.bGU.bGW = r1;
            sVar.bGU.bGY = jE;
            com.tencent.mm.sdk.b.a.sFg.m(sVar);
            if (sVar.bGV.bGZ) {
                x.i("MicroMsg.Audio.JsApiOperateAudio", "play audio ok");
            } else if (b.jD(this.bGW)) {
                this.fHX = true;
                this.fHW = "audio is playing, don't play again";
            } else {
                this.fHX = true;
                this.fHW = "play audio fail";
            }
        } else if (str.equalsIgnoreCase("pause")) {
            x.d("MicroMsg.AudioPlayerHelper", "pauseAudio, audioId:%s", this.bGW);
            sVar2 = new s();
            sVar2.bGU.action = 2;
            sVar2.bGU.bGW = str;
            com.tencent.mm.sdk.b.a.sFg.m(sVar2);
            if (sVar2.bGV.bGZ) {
                x.i("MicroMsg.Audio.JsApiOperateAudio", "pause audio ok");
            } else {
                this.fHX = true;
                this.fHW = "pause audio fail";
            }
        } else if (str.equalsIgnoreCase("seek")) {
            x.i("MicroMsg.Audio.JsApiOperateAudio", "currentTime:%d", Integer.valueOf(this.bGX));
            if (this.bGX < 0) {
                x.e("MicroMsg.Audio.JsApiOperateAudio", "currentTime %d is invalid!", Integer.valueOf(this.bGX));
                this.fHX = true;
                this.fHW = "currentTime is invalid";
            } else {
                x.i("MicroMsg.AudioPlayerHelper", "seekToAudio, audioId:%s, currentTime:%d", this.bGW, Integer.valueOf(this.bGX));
                sVar = new s();
                sVar.bGU.action = 4;
                sVar.bGU.bGW = str;
                sVar.bGU.bGX = r1;
                com.tencent.mm.sdk.b.a.sFg.m(sVar);
                if (sVar.bGV.bGZ) {
                    x.i("MicroMsg.Audio.JsApiOperateAudio", "seek audio ok");
                } else {
                    this.fHX = true;
                    this.fHW = "seek audio fail";
                }
            }
        } else if (str.equalsIgnoreCase("stop")) {
            boolean z;
            str = this.bGW;
            sVar2 = new s();
            sVar2.bGU.action = 13;
            sVar2.bGU.bGW = str;
            com.tencent.mm.sdk.b.a.sFg.m(sVar2);
            if (sVar2.bGV.bGZ) {
                x.i("MicroMsg.AudioPlayerHelper", "stopAudioOnBackground, audioId:%s", str);
                sVar2 = new s();
                sVar2.bGU.action = 14;
                sVar2.bGU.bGW = str;
                com.tencent.mm.sdk.b.a.sFg.m(sVar2);
                z = sVar2.bGV.bGZ;
            } else {
                sVar2 = new s();
                sVar2.bGU.action = 17;
                sVar2.bGU.bGW = str;
                com.tencent.mm.sdk.b.a.sFg.m(sVar2);
                if (sVar2.bGV.bGZ) {
                    z = true;
                } else {
                    x.i("MicroMsg.AudioPlayerHelper", "stopAudio, audioId:%s", str);
                    sVar2 = new s();
                    sVar2.bGU.action = 3;
                    sVar2.bGU.bGW = str;
                    com.tencent.mm.sdk.b.a.sFg.m(sVar2);
                    z = sVar2.bGV.bGZ;
                }
            }
            if (z) {
                x.i("MicroMsg.Audio.JsApiOperateAudio", "stop audio ok");
            } else {
                this.fHX = true;
                this.fHW = "stop audio fail";
            }
        } else {
            x.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is invalid");
            this.fHX = true;
            this.fHW = "operationType is invalid";
        }
        if (this.fHX) {
            x.e("MicroMsg.Audio.JsApiOperateAudio", this.fHW);
        }
        En();
    }

    public final void En() {
        super.En();
        if (this.fFa == null) {
            x.e("MicroMsg.Audio.JsApiOperateAudio", "server is null");
        } else if (this.fHX) {
            this.fFa.E(this.fFd, this.fFF.f("fail:" + this.fHW, null));
        } else {
            this.fFa.E(this.fFd, this.fFF.f("ok", null));
        }
    }
}
