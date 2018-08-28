package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class g$65 implements OnClickListener {
    final /* synthetic */ String bAj;
    final /* synthetic */ String gkR;
    final /* synthetic */ String jHJ;
    final /* synthetic */ int kfG;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ int qjA;
    final /* synthetic */ boolean qjB;
    final /* synthetic */ int qjz;

    g$65(g gVar, i iVar, String str, String str2, int i, int i2, int i3, String str3, boolean z) {
        this.qiK = gVar;
        this.qiH = iVar;
        this.bAj = str;
        this.jHJ = str2;
        this.kfG = i;
        this.qjz = i2;
        this.qjA = i3;
        this.gkR = str3;
        this.qjB = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.a(this.qiK, this.qiH, this.bAj, this.jHJ, this.kfG, this.qjz, this.qjA, this.gkR, this.qjB);
    }
}
