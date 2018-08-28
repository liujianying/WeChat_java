package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.xweb.f;

class WebViewUI$h$2 implements OnClickListener {
    final /* synthetic */ f jKb;
    final /* synthetic */ h qaH;
    final /* synthetic */ PBool qaI;

    WebViewUI$h$2(h hVar, PBool pBool, f fVar) {
        this.qaH = hVar;
        this.qaI = pBool;
        this.jKb = fVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.qaI.value = true;
        this.jKb.confirm();
    }
}
