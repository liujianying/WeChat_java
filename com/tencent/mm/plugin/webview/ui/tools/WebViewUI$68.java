package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;

class WebViewUI$68 implements OnApplyWindowInsetsListener {
    final /* synthetic */ ViewGroup jVd;
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$68(WebViewUI webViewUI, ViewGroup viewGroup) {
        this.pZJ = webViewUI;
        this.jVd = viewGroup;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        this.pZJ.a(this.jVd, windowInsets);
        return windowInsets.consumeSystemWindowInsets();
    }
}
