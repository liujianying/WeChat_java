package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.f;

class WebViewUI$h$9 implements OnDismissListener {
    final /* synthetic */ f jKb;
    final /* synthetic */ h qaH;
    final /* synthetic */ PBool qaI;

    WebViewUI$h$9(h hVar, PBool pBool, f fVar) {
        this.qaH = hVar;
        this.qaI = pBool;
        this.jKb = fVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        x.d("MicroMsg.WebViewUI", "onJsConfirm, onDismiss");
        if (!this.qaI.value) {
            this.jKb.cancel();
        }
    }
}
