package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.21;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.a;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.Map;

class WebViewUI$13 implements a {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$13(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final boolean wi(String str) {
        if (this.pZJ.pNV != null) {
            d dVar = this.pZJ.pNV;
            Map hashMap = new HashMap();
            hashMap.put("smiley", str);
            ah.A(new 21(dVar, i.a.a("onGetSmiley", hashMap, dVar.qhs, dVar.qht)));
        }
        return true;
    }
}
