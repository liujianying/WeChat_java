package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.model.ad;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.e;

class g$79 implements OnCancelListener {
    final /* synthetic */ String jHJ;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ b qjy;

    g$79(g gVar, b bVar, String str, i iVar) {
        this.qiK = gVar;
        this.qjy = bVar;
        this.jHJ = str;
        this.qiH = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        e.bUW().a(this.qjy);
        e.bUW();
        ad.rq(this.jHJ);
        g.a(this.qiK, this.qiH, "uploadVoice:fail", null);
    }
}
