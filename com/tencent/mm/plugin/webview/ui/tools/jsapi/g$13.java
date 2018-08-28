package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class g$13 implements OnDismissListener {
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$13(g gVar, i iVar) {
        this.qiK = gVar;
        this.qiH = iVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        g.a(this.qiK, this.qiH, "share_weibo:not_bind_qq", null);
    }
}
