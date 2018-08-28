package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class g$27 implements OnDismissListener {
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$27(g gVar, i iVar) {
        this.qiK = gVar;
        this.qiH = iVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        g.a(this.qiK, this.qiH, "share_weibo:no_weibo", null);
    }
}
