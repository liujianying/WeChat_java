package com.tencent.mm.plugin.webview.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.model.z.b;
import com.tencent.mm.plugin.webview.model.z.d;
import com.tencent.mm.sdk.platformtools.x;

class z$c$1 implements OnCancelListener {
    final /* synthetic */ d pRw;
    final /* synthetic */ b pRx;

    z$c$1(d dVar, b bVar) {
        this.pRw = dVar;
        this.pRx = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize user cancel");
        this.pRw.aFs();
        this.pRx.remove(1254);
    }
}
