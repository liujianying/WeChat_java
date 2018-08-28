package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class WebViewInputFooter$1 implements OnClickListener {
    final /* synthetic */ WebViewInputFooter qlJ;

    WebViewInputFooter$1(WebViewInputFooter webViewInputFooter) {
        this.qlJ = webViewInputFooter;
    }

    public final void onClick(View view) {
        if (WebViewInputFooter.a(this.qlJ) == 0) {
            WebViewInputFooter.b(this.qlJ).YC();
            if (!WebViewInputFooter.c(this.qlJ)) {
                WebViewInputFooter.d(this.qlJ).requestFocus();
            }
            WebViewInputFooter.e(this.qlJ);
            WebViewInputFooter.f(this.qlJ).setImageResource(R.k.textfield_icon_emoji_pressed);
            WebViewInputFooter.a(this.qlJ, 1);
            WebViewInputFooter.g(this.qlJ);
            return;
        }
        WebViewInputFooter.g(this.qlJ);
        WebViewInputFooter.d(this.qlJ).requestFocus();
        WebViewInputFooter.b(this.qlJ).showVKB();
        WebViewInputFooter.h(this.qlJ);
        WebViewInputFooter.a(this.qlJ, 0);
    }
}
