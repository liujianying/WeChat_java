package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.model.j;

class g$92 implements OnCancelListener {
    final /* synthetic */ g qiK;
    final /* synthetic */ j qjQ;

    g$92(g gVar, j jVar) {
        this.qiK = gVar;
        this.qjQ = jVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.qjQ);
    }
}
