package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.tools.g.a;

class WebViewInputFooter$4 implements OnClickListener {
    final /* synthetic */ WebViewInputFooter qlJ;

    WebViewInputFooter$4(WebViewInputFooter webViewInputFooter) {
        this.qlJ = webViewInputFooter;
    }

    public final void onClick(View view) {
        c Gi = c.d(WebViewInputFooter.d(this.qlJ)).Gi(WebViewInputFooter.l(this.qlJ));
        Gi.gHz = a.uzY;
        Gi.uCR = true;
        Gi.a(new 1(this));
    }
}
