package com.tencent.mm.plugin.music.b.a;

import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ boolean lAb;
    final /* synthetic */ b lAc;

    b$1(b bVar, boolean z) {
        this.lAc = bVar;
        this.lAb = z;
    }

    public final void run() {
        x.i("MicroMsg.Music.BasePlayer", "onError, needRetry:%b", new Object[]{Boolean.valueOf(this.lAb)});
        this.lAc.lzZ.d(this.lAc.bTF, this.lAb);
    }
}
