package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.ui.base.h.c;

class QRCodeIntroductionWebViewUI$3 implements c {
    final /* synthetic */ QRCodeIntroductionWebViewUI pWm;

    QRCodeIntroductionWebViewUI$3(QRCodeIntroductionWebViewUI qRCodeIntroductionWebViewUI) {
        this.pWm = qRCodeIntroductionWebViewUI;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                this.pWm.pNV.bXV();
                return;
            case 1:
                this.pWm.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.pWm.getRawUrl())));
                return;
            default:
                return;
        }
    }
}
