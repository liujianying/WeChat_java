package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer;
import com.tencent.mm.sdk.platformtools.x;

class JsApiOperateMusicPlayer$OperateMusicPlayer$2 implements Runnable {
    final /* synthetic */ OperateMusicPlayer fIB;

    JsApiOperateMusicPlayer$OperateMusicPlayer$2(OperateMusicPlayer operateMusicPlayer) {
        this.fIB = operateMusicPlayer;
    }

    public final void run() {
        x.i("MicroMsg.JsApiOperateMusicPlayer", "resume ok");
        this.fIB.action = -1;
        this.fIB.errorMsg = "";
        this.fIB.fHX = false;
        OperateMusicPlayer.d(this.fIB);
    }
}
