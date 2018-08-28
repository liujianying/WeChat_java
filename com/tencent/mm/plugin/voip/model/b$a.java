package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.x;
import java.util.TimerTask;

class b$a extends TimerTask {
    final /* synthetic */ b oHI;

    b$a(b bVar) {
        this.oHI = bVar;
    }

    public final void run() {
        System.currentTimeMillis();
        if (b.a(this.oHI) == 1 && this.oHI.oGX) {
            System.currentTimeMillis();
            if (b.b(this.oHI) + this.oHI.eps < b.c(this.oHI) && b.d(this.oHI) == 0) {
                b.a(this.oHI, 1);
                int P = this.oHI.oHi.P(b.e(this.oHI), this.oHI.eps);
                b.a(this.oHI, 0);
                if (P < 0) {
                    x.d("MicroMsg.Voip.AudioPlayer", "Task AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :" + P);
                    return;
                }
                synchronized (b.f(this.oHI)) {
                    System.arraycopy(b.e(this.oHI), 0, b.g(this.oHI), b.b(this.oHI), this.oHI.eps);
                    b.b(this.oHI, b.b(this.oHI) + this.oHI.eps);
                    b.c(this.oHI, b.h(this.oHI) + (this.oHI.eps >> 1));
                }
            }
        }
    }
}
