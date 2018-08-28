package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.bg.d;

class g$20 implements Runnable {
    final /* synthetic */ g qiK;
    final /* synthetic */ Intent val$intent;

    g$20(g gVar, Intent intent) {
        this.qiK = gVar;
        this.val$intent = intent;
    }

    public final void run() {
        d.b(g.j(this.qiK), "webview", ".ui.tools.WebViewUI", this.val$intent);
    }
}
