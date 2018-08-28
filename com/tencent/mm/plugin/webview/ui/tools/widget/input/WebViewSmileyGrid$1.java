package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.br.e;

class WebViewSmileyGrid$1 implements OnItemClickListener {
    final /* synthetic */ WebViewSmileyGrid qlN;

    WebViewSmileyGrid$1(WebViewSmileyGrid webViewSmileyGrid) {
        this.qlN = webViewSmileyGrid;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == WebViewSmileyGrid.a(this.qlN).getCount() - 1) {
            if (WebViewSmileyGrid.b(this.qlN).qlS != null) {
                WebViewSmileyGrid.b(this.qlN).qlS.apK();
            }
        } else if ((WebViewSmileyGrid.c(this.qlN) * (WebViewSmileyGrid.d(this.qlN) - 1)) + i < WebViewSmileyGrid.e(this.qlN)) {
            int c = (WebViewSmileyGrid.c(this.qlN) * (WebViewSmileyGrid.d(this.qlN) - 1)) + i;
            if (WebViewSmileyGrid.b(this.qlN).qlS != null) {
                WebViewSmileyGrid.b(this.qlN).qlS.append(e.cjH().mi(c));
            }
        }
    }
}
