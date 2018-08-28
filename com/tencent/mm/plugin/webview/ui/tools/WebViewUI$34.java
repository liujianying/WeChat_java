package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.g.a.pb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$34 extends c<pb> {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$34(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
        this.sFo = pb.class.getName().hashCode();
    }

    private boolean bWH() {
        if (this.pZJ.gcO == null) {
            x.e("MicroMsg.WebViewUI", "Cli Event, invoker is null");
        } else if (WebViewUI.y(this.pZJ) == null || WebViewUI.y(this.pZJ).length() == 0) {
            x.e("MicroMsg.WebViewUI", "Cli Event, tid is null");
        } else {
            try {
                x.i("MicroMsg.WebViewUI", "Cli Event, tid = %s, stime = %d, etime = %d", new Object[]{WebViewUI.y(this.pZJ), Long.valueOf(WebViewUI.z(this.pZJ)), Long.valueOf(System.currentTimeMillis())});
                Bundle bundle = new Bundle();
                bundle.putString("service_click_tid", new String(WebViewUI.y(this.pZJ)));
                bundle.putLong("service_click_stime", WebViewUI.z(this.pZJ));
                bundle.putLong("service_click_etime", r0);
                this.pZJ.gcO.s(2836, bundle);
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "Cli Event Exception, msg = %s", new Object[]{e.getMessage()});
            }
            WebViewUI.a(this.pZJ, null);
        }
        return false;
    }
}
