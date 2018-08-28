package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;

class WebViewStubService$5 extends a {
    private final byte[] cWZ = new byte[0];
    final /* synthetic */ WebViewStubService pUR;

    WebViewStubService$5(WebViewStubService webViewStubService) {
        this.pUR = webViewStubService;
    }

    public final void ev(int i) {
        synchronized (this.cWZ) {
            try {
                String bUq = s.bUq();
                Bundle bundle = new Bundle();
                bundle.putString("webview_network_type", bUq);
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.h(this.pUR)) {
                    webViewStubCallbackWrapper.pXx.c(90, bundle);
                }
            } catch (Exception e) {
                x.e("MicroMsg.WebViewStubService", "notify network change failed :%s", new Object[]{e.getMessage()});
            }
        }
    }
}
