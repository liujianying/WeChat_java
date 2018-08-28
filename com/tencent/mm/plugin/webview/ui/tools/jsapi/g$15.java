package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.model.r;

class g$15 implements OnCancelListener {
    final /* synthetic */ g qiK;
    final /* synthetic */ r qiZ;

    g$15(g gVar, r rVar) {
        this.qiK = gVar;
        this.qiZ = rVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.qiZ);
    }
}
