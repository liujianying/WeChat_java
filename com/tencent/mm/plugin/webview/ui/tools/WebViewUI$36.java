package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.n.b;

class WebViewUI$36 implements b {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$36(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void a(TextView textView, MenuItem menuItem) {
        String str = menuItem.getTitle();
        if (textView != null) {
            String str2 = (String) WebViewUI.M(this.pZJ).get(str);
            if (bi.oW(str2)) {
                WebViewUI.d(textView, str);
            } else {
                textView.setText(j.a(this.pZJ.mController.tml, str2, textView.getTextSize()));
            }
        }
    }
}
