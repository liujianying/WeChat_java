package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class QRCodeIntroductionWebViewUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ QRCodeIntroductionWebViewUI pWm;

    QRCodeIntroductionWebViewUI$2(QRCodeIntroductionWebViewUI qRCodeIntroductionWebViewUI) {
        this.pWm = qRCodeIntroductionWebViewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pWm.finish();
        return true;
    }
}
