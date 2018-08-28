package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.model.w;

class g$112 implements OnCancelListener {
    final /* synthetic */ g qiK;
    final /* synthetic */ w qjX;

    g$112(g gVar, w wVar) {
        this.qiK = gVar;
        this.qjX = wVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.qjX);
    }
}
