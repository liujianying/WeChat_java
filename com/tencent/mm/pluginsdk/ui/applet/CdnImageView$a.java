package com.tencent.mm.pluginsdk.ui.applet;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;

class CdnImageView$a implements Runnable {
    private ag handler;
    private String url;

    CdnImageView$a(String str, ag agVar) {
        this.url = str;
        this.handler = agVar;
    }

    public final void run() {
        byte[] WY = bi.WY(this.url);
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putByteArray("k_data", WY);
        bundle.putString("k_url", this.url);
        obtain.setData(bundle);
        this.handler.sendMessage(obtain);
    }
}
