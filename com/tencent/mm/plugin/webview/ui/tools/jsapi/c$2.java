package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.webview.model.m;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements OnClickListener {
    final /* synthetic */ int bFr;
    final /* synthetic */ m qgZ;
    final /* synthetic */ c qhb;

    c$2(c cVar, m mVar, int i) {
        this.qhb = cVar;
        this.qgZ = mVar;
        this.bFr = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click cancel");
        this.qgZ.pRl.a(a.RET_REJECT, "cancel", null, this.bFr, this.qgZ.bTZ().rQI.bMH);
    }
}
