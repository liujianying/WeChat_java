package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.KeyEvent;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;

class WebViewInputFooter$3 implements a {
    final /* synthetic */ WebViewInputFooter qlJ;

    WebViewInputFooter$3(WebViewInputFooter webViewInputFooter) {
        this.qlJ = webViewInputFooter;
    }

    public final void append(String str) {
        try {
            if (WebViewInputFooter.c(this.qlJ)) {
                WebViewInputFooter.j(this.qlJ).wi(str);
            } else {
                this.qlJ.qlF.abr(str);
            }
        } catch (Exception e) {
            x.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[]{e});
        }
    }

    public final void apK() {
        if (WebViewInputFooter.c(this.qlJ) && WebViewInputFooter.j(this.qlJ) != null) {
            WebViewInputFooter.j(this.qlJ).wi("[DELETE_EMOTION]");
        } else if (WebViewInputFooter.d(this.qlJ) != null) {
            MMEditText d = WebViewInputFooter.d(this.qlJ);
            if (d.getInputConnection() != null) {
                d.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                d.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                return;
            }
            d.dispatchKeyEvent(new KeyEvent(0, 67));
            d.dispatchKeyEvent(new KeyEvent(1, 67));
        }
    }
}
