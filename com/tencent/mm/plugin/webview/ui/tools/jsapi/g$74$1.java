package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.ab.g.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.74;
import com.tencent.mm.sdk.platformtools.x;

class g$74$1 implements a {
    final /* synthetic */ 74 qjG;

    g$74$1(74 74) {
        this.qjG = 74;
    }

    public final void wd() {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("playResult", "onVoicePlayEnd:ok");
            bundle.putString("localId", this.qjG.fQh);
            this.qjG.qiK.pRY.c(2002, bundle);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", new Object[]{e.getMessage()});
        }
    }
}
