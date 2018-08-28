package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.model.l;

class g$12 implements OnCancelListener {
    final /* synthetic */ g qiK;
    final /* synthetic */ l qiY;

    g$12(g gVar, l lVar) {
        this.qiK = gVar;
        this.qiY = lVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.qiY);
    }
}
