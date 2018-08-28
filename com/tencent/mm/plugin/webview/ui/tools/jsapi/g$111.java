package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.webview.a.a;

class g$111 implements Runnable {
    final /* synthetic */ g qiK;
    final /* synthetic */ Intent val$intent;

    g$111(g gVar, Intent intent) {
        this.qiK = gVar;
        this.val$intent = intent;
    }

    public final void run() {
        a.ezn.d(this.val$intent, g.j(this.qiK));
    }
}
