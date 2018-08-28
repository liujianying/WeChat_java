package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import java.util.Map;

class WebViewUI$23$8 implements Runnable {
    final /* synthetic */ 23 pZM;
    final /* synthetic */ Map pZO;

    WebViewUI$23$8(23 23, Map map) {
        this.pZM = 23;
        this.pZO = map;
    }

    public final void run() {
        this.pZM.pZJ.setMMSubTitle(null);
        if (this.pZM.pZJ.pNV != null) {
            this.pZM.pZJ.pNV.ao(this.pZO);
        }
    }
}
