package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e$c;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.audio.d.a;
import com.tencent.mm.sdk.platformtools.x;

class d$1 extends b {
    final /* synthetic */ String bAj;
    final /* synthetic */ d fHV;

    d$1(d dVar, String str) {
        this.fHV = dVar;
        this.bAj = str;
    }

    public final void onCreate() {
        d.fHU = true;
    }

    public final void onResume() {
        d.fHU = true;
    }

    public final void a(e$c e_c) {
        x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onPause, appId:%s", new Object[]{this.bAj});
        d.fHU = false;
        a aVar = new a();
        aVar.bWA = 1;
        aVar.appId = this.bAj;
        aVar.ahT();
    }

    public final void onDestroy() {
        x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onDestroy, appId:%s", new Object[]{this.bAj});
        d.fHU = false;
        a aVar = new a();
        aVar.bWA = 2;
        aVar.appId = this.bAj;
        aVar.ahU();
        e.b(this.bAj, this);
        d.ahX().remove(this.bAj);
    }
}
