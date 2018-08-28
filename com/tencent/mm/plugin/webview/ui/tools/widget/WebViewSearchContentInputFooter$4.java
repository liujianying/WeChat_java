package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mm.ui.MMActivity;

class WebViewSearchContentInputFooter$4 implements OnKeyListener {
    final /* synthetic */ WebViewSearchContentInputFooter qlx;

    WebViewSearchContentInputFooter$4(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
        this.qlx = webViewSearchContentInputFooter;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (WebViewSearchContentInputFooter.c(this.qlx) != null) {
            WebViewSearchContentInputFooter.c(this.qlx).c(i, keyEvent);
        }
        if (i != 66 || WebViewSearchContentInputFooter.c(this.qlx) == null) {
            return false;
        }
        Context context = view.getContext();
        if (context instanceof MMActivity) {
            ((MMActivity) context).hideVKB(WebViewSearchContentInputFooter.d(this.qlx));
        }
        WebViewSearchContentInputFooter.c(this.qlx).b(this.qlx);
        return true;
    }
}
