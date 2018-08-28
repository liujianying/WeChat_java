package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class g$66 implements OnClickListener {
    final /* synthetic */ String gkR;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$66(g gVar, i iVar, String str) {
        this.qiK = gVar;
        this.qiH = iVar;
        this.gkR = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.a(this.qiK, this.qiH, this.gkR + ":cancel", null);
    }
}
