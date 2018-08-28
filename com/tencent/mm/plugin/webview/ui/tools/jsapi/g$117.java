package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class g$117 implements OnCancelListener {
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$117(g gVar, i iVar) {
        this.qiK = gVar;
        this.qiH = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.a(this.qiK, this.qiH, "chooseIdCard:cancel", null);
    }
}
