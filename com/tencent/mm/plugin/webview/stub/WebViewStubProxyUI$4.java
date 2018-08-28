package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.base.model.d.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

class WebViewStubProxyUI$4 implements a {
    final /* synthetic */ p hmi;
    final /* synthetic */ WebViewStubProxyUI pUE;

    WebViewStubProxyUI$4(WebViewStubProxyUI webViewStubProxyUI, p pVar) {
        this.pUE = webViewStubProxyUI;
        this.hmi = pVar;
    }

    public final void dF(boolean z) {
        if (this.hmi != null) {
            this.hmi.dismiss();
        }
        Bundle bundle;
        if (z) {
            if (WebViewStubProxyUI.a(this.pUE) != null) {
                bundle = new Bundle();
                bundle.putBoolean("add_shortcut_status", true);
                try {
                    WebViewStubProxyUI.a(this.pUE).g(54, bundle);
                } catch (Exception e) {
                    x.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + e.getMessage());
                }
            }
            h.a(this.pUE, R.l.wv_add_shortcut_success, R.l.app_tip, false, new 1(this));
            return;
        }
        Toast.makeText(this.pUE.mController.tml, this.pUE.mController.tml.getString(R.l.wv_add_shortcut_fail), 0).show();
        if (WebViewStubProxyUI.a(this.pUE) != null) {
            bundle = new Bundle();
            bundle.putBoolean("add_shortcut_status", false);
            try {
                WebViewStubProxyUI.a(this.pUE).g(54, bundle);
            } catch (Exception e2) {
                x.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + e2.getMessage());
            }
        }
        this.pUE.finish();
    }
}
