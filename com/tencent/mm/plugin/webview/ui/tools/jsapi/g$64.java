package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.model.ad;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.e;

class g$64 implements OnCancelListener {
    final /* synthetic */ String gkR;
    final /* synthetic */ String jHJ;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ b qjy;

    g$64(g gVar, b bVar, String str, i iVar, String str2) {
        this.qiK = gVar;
        this.qjy = bVar;
        this.jHJ = str;
        this.qiH = iVar;
        this.gkR = str2;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        e.bUW().a(this.qjy);
        e.bUW();
        ad.rq(this.jHJ);
        g.a(this.qiK, this.qiH, this.gkR + ":fail", null);
    }
}
