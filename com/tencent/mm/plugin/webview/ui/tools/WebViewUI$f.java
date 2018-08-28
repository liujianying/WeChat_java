package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class WebViewUI$f implements b {
    final /* synthetic */ WebViewUI pZJ;

    private WebViewUI$f(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    /* synthetic */ WebViewUI$f(WebViewUI webViewUI, byte b) {
        this(webViewUI);
    }

    public final boolean Dt(String str) {
        if (bi.oW(str)) {
            return false;
        }
        return s.fj(str, "weixin://");
    }

    public final boolean Du(String str) {
        int b = WebViewUI.b(this.pZJ, bi.oV(WebViewUI.aQ(this.pZJ)));
        if (!d.al(str, WebViewUI.aR(this.pZJ))) {
            return false;
        }
        try {
            if ("weixin://dl/shopping".equals(str)) {
                String bVs = this.pZJ.gcO.bVs();
                if (!bi.oW(bVs)) {
                    this.pZJ.mhH.loadUrl(bVs);
                }
            } else if ("weixin://dl/faq".equals(str)) {
                int bVu = this.pZJ.gcO.bVu();
                int bVv = this.pZJ.gcO.bVv();
                this.pZJ.mhH.loadUrl(ad.getContext().getString(R.l.settings_system_notice_url, new Object[]{Integer.valueOf(bVu), Integer.valueOf(bVv)}));
            } else if ("weixin://dl/posts".equals(str)) {
                this.pZJ.gcO.bVw();
            } else if ("weixin://dl/moments".equals(str)) {
                this.pZJ.gcO.bVx();
            } else if (str.startsWith("weixin://dl/feedback")) {
                this.pZJ.gcO.QY(str);
            } else if ("weixin://dl/scan".equals(str)) {
                com.tencent.mm.bg.d.c(this.pZJ, "scanner", ".ui.SingleTopScanUI", new Intent());
            } else {
                d.SD(str);
            }
            List arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add("1");
            arrayList.add(String.valueOf(b));
            arrayList.add(bi.oV(WebViewUI.aQ(this.pZJ)));
            arrayList.add(bi.oV(this.pZJ.cbP));
            this.pZJ.gcO.g(11405, arrayList);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "kv report fail, ex = %s", new Object[]{e.getMessage()});
            return true;
        }
    }
}
