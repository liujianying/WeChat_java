package com.tencent.mm.plugin.nearlife.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;

class LogoImageView$a implements Runnable {
    private ag handler;
    private String url;

    LogoImageView$a(String str, ag agVar) {
        this.url = str;
        this.handler = agVar;
    }

    public final void run() {
        Object WY = bi.WY(this.url);
        Message obtain = Message.obtain();
        obtain.obj = WY;
        this.handler.sendMessage(obtain);
    }
}
