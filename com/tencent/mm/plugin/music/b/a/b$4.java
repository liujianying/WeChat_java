package com.tencent.mm.plugin.music.b.a;

import com.tencent.mm.sdk.platformtools.x;

class b$4 implements Runnable {
    final /* synthetic */ b lAc;
    final /* synthetic */ boolean lAd;

    b$4(b bVar, boolean z) {
        this.lAc = bVar;
        this.lAd = z;
    }

    public final void run() {
        x.i("MicroMsg.Music.BasePlayer", "onStop, isComplete:%b", new Object[]{Boolean.valueOf(this.lAd)});
        this.lAc.lzZ.c(this.lAc.bTF, this.lAd);
    }
}
