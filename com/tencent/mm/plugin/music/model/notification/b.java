package com.tencent.mm.plugin.music.model.notification;

import android.content.Intent;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public c fIu;
    public MMMusicPlayerService lzf;
    volatile boolean lzl = false;

    final synchronized void biq() {
        if (this.lzf == null || !this.lzl) {
            this.lzl = true;
            Intent intent = new Intent();
            intent.setClass(ad.getContext(), MMMusicPlayerService.class);
            boolean bindService = ad.getContext().bindService(intent, new 2(this), 1);
            x.i("MicroMsg.Music.MMMusicNotificationHelper", "isOk:%b", new Object[]{Boolean.valueOf(bindService)});
        }
    }
}
