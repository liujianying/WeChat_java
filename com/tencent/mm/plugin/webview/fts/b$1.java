package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.pluginsdk.model.app.g;

class b$1 implements Runnable {
    final /* synthetic */ Context ePr;
    final /* synthetic */ b pOa;
    final /* synthetic */ Intent val$intent;

    b$1(b bVar, Context context, Intent intent) {
        this.pOa = bVar;
        this.ePr = context;
        this.val$intent = intent;
    }

    public final void run() {
        g.a(this.ePr, this.val$intent, "");
    }
}
