package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class QRCodeIntroductionWebViewUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ QRCodeIntroductionWebViewUI pWm;

    QRCodeIntroductionWebViewUI$1(QRCodeIntroductionWebViewUI qRCodeIntroductionWebViewUI) {
        this.pWm = qRCodeIntroductionWebViewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        QRCodeIntroductionWebViewUI.a(this.pWm);
        return true;
    }
}
