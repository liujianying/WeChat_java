package com.tencent.mm.plugin.game.gamewebview.e;

import android.webkit.ValueCallback;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements ValueCallback<String> {
    final /* synthetic */ b jKU;

    b$2(b bVar) {
        this.jKU = bVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        x.i("MicroMsg.GameWebView", "WeixinJSBridge, ret = %s", (String) obj);
        if (bi.oW((String) obj)) {
            h.mEJ.a(609, 2, 1, false);
        }
    }
}
