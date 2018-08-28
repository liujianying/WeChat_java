package com.tencent.mm.plugin.game.gamewebview.e;

import android.webkit.ValueCallback;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements ValueCallback<String> {
    final /* synthetic */ b jKU;

    b$1(b bVar) {
        this.jKU = bVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        x.i("MicroMsg.GameWebView", "injectJavaScript, ret = %s", (String) obj);
        if (bi.oW((String) obj)) {
            h.mEJ.a(609, 2, 1, false);
        } else {
            h.mEJ.a(609, 3, 1, false);
        }
    }
}
