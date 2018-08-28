package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.xweb.f;

class WebViewUI$h$10 implements OnClickListener {
    final /* synthetic */ f jKb;
    final /* synthetic */ h qaH;
    final /* synthetic */ String val$url;

    WebViewUI$h$10(h hVar, String str, f fVar) {
        this.qaH = hVar;
        this.val$url = str;
        this.jKb = fVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        com.tencent.mm.plugin.report.service.h.mEJ.h(11683, new Object[]{this.val$url, Integer.valueOf(1), Integer.valueOf(this.qaH.pZJ.jJE)});
        this.jKb.cancel();
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this.qaH.pZJ.finish();
    }
}
