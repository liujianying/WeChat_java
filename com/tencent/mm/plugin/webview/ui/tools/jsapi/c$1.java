package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.webview.model.m;
import com.tencent.mm.protocal.c.aoc;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements OnClickListener {
    final /* synthetic */ int bFr;
    final /* synthetic */ m qgZ;
    final /* synthetic */ aoc qha;
    final /* synthetic */ c qhb;

    c$1(c cVar, m mVar, int i, aoc aoc) {
        this.qhb = cVar;
        this.qgZ = mVar;
        this.bFr = i;
        this.qha = aoc;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click ok");
        this.qhb.a(this.qgZ, this.bFr, this.qha);
    }
}
