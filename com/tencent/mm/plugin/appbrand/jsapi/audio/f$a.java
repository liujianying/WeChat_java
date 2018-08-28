package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.g.a.s;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.c;
import java.util.HashMap;
import java.util.Map;

class f$a extends a {
    public String appId = "";
    public String bGW = "";
    public int bGX;
    public int dGB;
    public String dGC;
    public int dGs;
    public int duration = 0;
    public int eiO;
    private e fFF;
    public l fFa;
    public int fFd;
    public String fHW;
    public boolean fHX = false;

    public f$a(e eVar, l lVar, int i) {
        this.fFF = eVar;
        this.fFa = lVar;
        this.fFd = i;
    }

    public final void ahW() {
        String str = this.bGW;
        s sVar = new s();
        sVar.bGU.action = 6;
        sVar.bGU.bGW = str;
        a.sFg.m(sVar);
        c cVar = sVar.bGV.bHa;
        if (cVar == null) {
            x.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, audioState is null, audioId:%s", new Object[]{this.bGW});
            this.fHX = true;
            this.fHW = "return parameter is invalid";
            En();
        } else if (cVar.duration < 0 || cVar.bGX < 0) {
            x.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, duration:%d, currentTime:%d", new Object[]{Integer.valueOf(cVar.duration), Integer.valueOf(cVar.bGX)});
            this.fHX = true;
            this.fHW = "return parameter is invalid";
            En();
        } else {
            this.duration = cVar.duration;
            this.bGX = cVar.bGX;
            this.eiO = cVar.dGz ? 1 : 0;
            this.dGC = cVar.dGC;
            this.dGB = cVar.dGB;
            this.dGs = cVar.dGs;
            x.d("MicroMsg.Audio.JsApiGetAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d", new Object[]{Integer.valueOf(this.duration), Integer.valueOf(this.bGX), Integer.valueOf(this.eiO), Integer.valueOf(this.dGB), this.dGC, Integer.valueOf(this.dGs)});
            En();
        }
    }

    public final void En() {
        if (this.fFa == null) {
            x.e("MicroMsg.Audio.JsApiGetAudioState", "service is null");
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put("duration", Integer.valueOf(this.duration));
        hashMap.put("currentTime", Integer.valueOf(this.bGX));
        hashMap.put("paused", Boolean.valueOf(this.eiO == 1));
        hashMap.put("buffered", Integer.valueOf(this.dGB));
        hashMap.put("src", this.dGC);
        hashMap.put("startTime", Integer.valueOf(this.dGs));
        String str = TextUtils.isEmpty(this.fHW) ? "" : this.fHW;
        if (this.fHX) {
            x.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState fail, err:%s", new Object[]{str});
            this.fFa.E(this.fFd, this.fFF.f("fail:" + str, null));
            return;
        }
        this.fFa.E(this.fFd, this.fFF.f("ok", hashMap));
    }
}
