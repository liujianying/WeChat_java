package com.tencent.mm.plugin.music.model.notification;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class MMMusicPlayerService$1 implements Runnable {
    final /* synthetic */ MMMusicPlayerService lzp;

    MMMusicPlayerService$1(MMMusicPlayerService mMMusicPlayerService) {
        this.lzp = mMMusicPlayerService;
    }

    public final void run() {
        x.i("MicroMsg.Music.MMMusicPlayerService", "quit");
        ah.M(MMMusicPlayerService.a(this.lzp));
        this.lzp.stopSelf();
    }
}
