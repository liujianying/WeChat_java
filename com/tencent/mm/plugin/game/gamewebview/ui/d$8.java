package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b;

class d$8 implements b {
    final /* synthetic */ d jJO;

    d$8(d dVar) {
        this.jJO = dVar;
    }

    public final void aSX() {
        this.jJO.qM(0);
    }

    public final void aSY() {
        WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout) this.jJO.findViewById(R.h.webview_keyboard_ll);
        if (webViewKeyboardLinearLayout != null && webViewKeyboardLinearLayout.getKeyBoardHeight() > 0) {
            this.jJO.qM(webViewKeyboardLinearLayout.getKeyBoardHeight());
        }
    }
}
