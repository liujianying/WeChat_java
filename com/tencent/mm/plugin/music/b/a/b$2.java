package com.tencent.mm.plugin.music.b.a;

import com.tencent.mm.sdk.platformtools.x;

class b$2 implements Runnable {
    final /* synthetic */ b lAc;

    b$2(b bVar) {
        this.lAc = bVar;
    }

    public final void run() {
        x.i("MicroMsg.Music.BasePlayer", "onStart %b", new Object[]{Boolean.valueOf(this.lAc.isPlaying())});
        this.lAc.lzZ.m(this.lAc.bTF);
    }
}
