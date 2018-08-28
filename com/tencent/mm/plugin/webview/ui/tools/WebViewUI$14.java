package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b;

class WebViewUI$14 implements b {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$14(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void aSX() {
        WebViewUI.b(this.pZJ, 0);
    }

    public final void aSY() {
        WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout) this.pZJ.findViewById(R.h.webview_keyboard_ll);
        if (webViewKeyboardLinearLayout != null && webViewKeyboardLinearLayout.getKeyBoardHeight() > 0) {
            WebViewUI.b(this.pZJ, webViewKeyboardLinearLayout.getKeyBoardHeight());
        }
    }
}
