package com.tencent.mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;

final class s implements Runnable {
    private String appId = null;
    private int efG = 0;
    private ag handler = null;
    private String url = null;

    public s(ag agVar, String str, int i, String str2) {
        this.handler = agVar;
        this.appId = str;
        this.efG = i;
        this.url = str2;
    }

    public final void run() {
        if (this.appId != null && this.appId.length() != 0 && this.url != null && this.url.length() != 0) {
            v vVar = new v(this.appId, this.efG, bi.WY(this.url));
            Message obtain = Message.obtain();
            obtain.obj = vVar;
            this.handler.sendMessage(obtain);
        }
    }
}
