package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.plugin.multitalk.a.k.c;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.x;

protected class k$b implements Runnable {
    final /* synthetic */ k lut;
    private c luu;

    public k$b(k kVar, c cVar) {
        this.lut = kVar;
        this.luu = cVar;
    }

    public final void run() {
        if (this.luu != null) {
            x.d("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "draw user %s threadId %d", new Object[]{this.luu.username, Long.valueOf(Thread.currentThread().getId())});
            if (this.lut.ltC != null) {
                this.lut.ltC.a(this.luu.username, this.luu.luv, this.luu.lux, this.luu.luy, OpenGlRender.oUH);
            }
            try {
                this.lut.lum.put(this.luu);
            } catch (InterruptedException e) {
            }
        }
    }
}
