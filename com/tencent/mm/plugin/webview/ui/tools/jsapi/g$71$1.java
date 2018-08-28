package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.71;
import com.tencent.mm.sdk.platformtools.x;

class g$71$1 implements Runnable {
    final /* synthetic */ ff qjE;
    final /* synthetic */ 71 qjF;

    g$71$1(71 71, ff ffVar) {
        this.qjF = 71;
        this.qjE = ffVar;
    }

    public final void run() {
        x.i("MicroMsg.MsgHandler", "onVoiceRecordEnd, localId(%s).", new Object[]{this.qjF.qjD.bNH});
        try {
            g.C(this.qjF.qiK);
            Bundle bundle = new Bundle();
            bundle.putString("localId", this.qjF.qjD.bNH);
            String str = "recordResult";
            StringBuilder stringBuilder = new StringBuilder("onVoiceRecordEnd:");
            String str2 = (this.qjE.bNq.bNr != 2 || this.qjE.bNq.bNr == 3) ? "ok" : "fail";
            bundle.putString(str, stringBuilder.append(str2).toString());
            if (g.D(this.qjF.qiK) != null) {
                g.D(this.qjF.qiK).c(2008, bundle);
            } else {
                x.e("MicroMsg.MsgHandler", "callbacker is null");
            }
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "callback stop record failed");
        }
    }
}
