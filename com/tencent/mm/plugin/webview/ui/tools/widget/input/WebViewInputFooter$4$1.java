package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.widget.Toast;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.4;
import com.tencent.mm.ui.tools.a.c.a;

class WebViewInputFooter$4$1 implements a {
    final /* synthetic */ 4 qlK;

    WebViewInputFooter$4$1(4 4) {
        this.qlK = 4;
    }

    public final void pO(String str) {
        if (WebViewInputFooter.k(this.qlK.qlJ) != null) {
            WebViewInputFooter.k(this.qlK.qlJ).Ds(WebViewInputFooter.d(this.qlK.qlJ).getText().toString());
        }
        WebViewInputFooter webViewInputFooter = this.qlK.qlJ;
        webViewInputFooter.qlF.clearComposingText();
        webViewInputFooter.qlF.setText("");
    }

    public final void YX() {
    }

    public final void YY() {
        if (WebViewInputFooter.b(this.qlK.qlJ) != null) {
            Toast.makeText(WebViewInputFooter.b(this.qlK.qlJ), "exceed max-length", 0).show();
        }
    }
}
