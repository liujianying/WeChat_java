package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.am.a;

class g$100 implements OnCancelListener {
    final /* synthetic */ String dhF;
    final /* synthetic */ g qiK;

    g$100(g gVar, String str) {
        this.qiK = gVar;
        this.dhF = str;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a.dBr.iw(this.dhF);
        g.a(this.qiK, g.k(this.qiK), "profile:cancel", null);
    }
}
