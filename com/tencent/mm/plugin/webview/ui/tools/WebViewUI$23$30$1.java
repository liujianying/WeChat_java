package com.tencent.mm.plugin.webview.ui.tools;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23.30;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$23$30$1 implements OnCreateContextMenuListener {
    final /* synthetic */ 30 qag;

    WebViewUI$23$30$1(30 30) {
        this.qag = 30;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (this.qag.pZM.pZJ.gcV != null) {
            x.d("MicroMsg.WebViewUI", "show webkit menu");
            WebViewUI.a(this.qag.pZM.pZJ, contextMenu, this.qag.pZM.pZJ.gcV);
            this.qag.pZM.pZJ.gcV = null;
        } else if (this.qag.pZM.pZJ.gcW != null) {
            x.d("MicroMsg.WebViewUI", "show IX5 menu");
            WebViewUI.b(this.qag.pZM.pZJ, contextMenu, this.qag.pZM.pZJ.gcW);
            this.qag.pZM.pZJ.gcW = null;
        }
    }
}
