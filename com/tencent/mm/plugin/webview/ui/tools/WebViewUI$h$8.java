package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.xweb.f;

class WebViewUI$h$8 implements OnClickListener {
    final /* synthetic */ f jKb;
    final /* synthetic */ h qaH;

    WebViewUI$h$8(h hVar, f fVar) {
        this.qaH = hVar;
        this.jKb = fVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.jKb.cancel();
    }
}
