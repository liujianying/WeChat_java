package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.model.ad;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.e;

class g$81 implements OnCancelListener {
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ String qjx;
    final /* synthetic */ b qjy;

    g$81(g gVar, b bVar, String str, i iVar) {
        this.qiK = gVar;
        this.qjy = bVar;
        this.qjx = str;
        this.qiH = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        e.bUW().a(this.qjy);
        e.bUW();
        ad.Qm(this.qjx);
        g.a(this.qiK, this.qiH, "downloadVoice:fail", null);
    }
}
