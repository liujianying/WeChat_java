package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer;
import com.tencent.mm.sdk.platformtools.x;

class JsApiOperateMusicPlayer$OperateMusicPlayer$3 implements Runnable {
    final /* synthetic */ OperateMusicPlayer fIB;

    JsApiOperateMusicPlayer$OperateMusicPlayer$3(OperateMusicPlayer operateMusicPlayer) {
        this.fIB = operateMusicPlayer;
    }

    public final void run() {
        x.i("MicroMsg.JsApiOperateMusicPlayer", "pause ok");
        this.fIB.action = -1;
        this.fIB.fHX = false;
        this.fIB.errorMsg = "";
        OperateMusicPlayer.e(this.fIB);
    }
}
