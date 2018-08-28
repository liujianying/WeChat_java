package com.tencent.mm.plugin.webview.ui.tools;

import android.net.Uri;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i$a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

class WebViewUI$27 implements a {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$27(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void bWG() {
        int I;
        int i = 2;
        boolean z = false;
        try {
            if (this.pZJ.gcO.aSn()) {
                if (this.pZJ.bWr() || this.pZJ.bWs()) {
                    I = WebViewUI.I(this.pZJ);
                    if (I > 0 && I <= 4) {
                        i = I;
                    }
                    WebViewUI.d(this.pZJ, i);
                    this.pZJ.M(true, true);
                    if (this.pZJ.mhH != null && this.pZJ.gcP != null && this.pZJ.pNV != null) {
                        String url = this.pZJ.mhH.getUrl();
                        if (!bi.oW(url) && WebViewUI.J(this.pZJ).add(url)) {
                            GeneralControlWrapper bVS = this.pZJ.gcP.bVS();
                            boolean z2 = (bVS.qVZ & 512) > 0;
                            x.d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = " + z2);
                            if (z2) {
                                d dVar = this.pZJ.pNV;
                                x.i("MicroMsg.JsApiHandler", "getAllHostsInPage, ready(%s).", new Object[]{Boolean.valueOf(dVar.qhq)});
                                if (dVar.qhk != null && dVar.qhq) {
                                    dVar.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i$a.a("sys:get_all_hosts", new HashMap(), dVar.qhs, dVar.qht) + ")", null);
                                }
                            }
                            if ((bVS.qVZ & 1024) > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            x.d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = " + z2);
                            if (z2) {
                                this.pZJ.pNV.kl(false);
                                return;
                            }
                            ah m = WebViewUI.m(this.pZJ);
                            if (!bi.oW(url)) {
                                url = Uri.parse(url).getHost();
                                if (!bi.oW(url)) {
                                    z = m.pRV.remove(url);
                                }
                            }
                            if (z) {
                                this.pZJ.pNV.kl(true);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (bi.oW(this.pZJ.cbP) || !com.tencent.mm.plugin.webview.a.pNp.matcher(this.pZJ.cbP).matches()) {
                    I = this.pZJ.gcO.ej(16384, 2);
                } else {
                    I = this.pZJ.gcO.ej(16388, 2);
                }
                i = I;
                WebViewUI.d(this.pZJ, i);
                this.pZJ.M(true, true);
                if (this.pZJ.mhH != null) {
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "onLoadJsApiFinished, ex = " + e.getMessage());
        }
        I = 2;
        i = I;
        WebViewUI.d(this.pZJ, i);
        this.pZJ.M(true, true);
        if (this.pZJ.mhH != null) {
        }
    }
}
