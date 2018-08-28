package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.model.ad;
import com.tencent.mm.plugin.webview.model.d$b;
import com.tencent.mm.plugin.webview.modeltools.e;

class g$69 implements OnCancelListener {
    final /* synthetic */ String gkR;
    final /* synthetic */ String jHJ;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ d$b qjy;

    g$69(g gVar, d$b d_b, String str, i iVar, String str2) {
        this.qiK = gVar;
        this.qjy = d_b;
        this.jHJ = str;
        this.qiH = iVar;
        this.gkR = str2;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        e.bUW().a(this.qjy);
        e.bUW();
        ad.rq(this.jHJ);
        g.B(this.qiK);
        g.a(this.qiK, this.qiH, this.gkR + ":cancel", null);
    }
}
