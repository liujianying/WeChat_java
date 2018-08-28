package com.tencent.mm.plugin.multitalk.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class k$a implements Runnable {
    int index;
    final /* synthetic */ k lut;

    k$a(k kVar, int i) {
        this.lut = kVar;
        this.index = i;
    }

    public final void run() {
        Looper.prepare();
        x.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "start drawer handler");
        this.lut.lun[this.index] = new ag();
        Looper.loop();
    }
}
