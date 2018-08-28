package com.tencent.mm.plugin.music.model.notification;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ a lzj;

    a$1(a aVar) {
        this.lzj = aVar;
    }

    public final void run() {
        x.i("MicroMsg.Music.MMMusicNotification", "close");
        ah.M(this.lzj.lzh);
        this.lzj.lzf.stopForeground(true);
    }
}
