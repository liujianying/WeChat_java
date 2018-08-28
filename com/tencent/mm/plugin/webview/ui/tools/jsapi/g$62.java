package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class g$62 implements OnCancelListener {
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$62(g gVar, i iVar) {
        this.qiK = gVar;
        this.qiH = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.a(this.qiK, this.qiH, "doChooseMedia:cancel", null);
    }
}
