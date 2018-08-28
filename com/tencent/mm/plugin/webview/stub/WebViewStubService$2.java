package com.tencent.mm.plugin.webview.stub;

import com.tencent.mm.g.a.mu;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WebViewStubService$2 extends c<mu> {
    final /* synthetic */ WebViewStubService pUR;

    WebViewStubService$2(WebViewStubService webViewStubService) {
        this.pUR = webViewStubService;
        this.sFo = mu.class.getName().hashCode();
    }

    private boolean a(mu muVar) {
        if ((muVar instanceof mu) && (WebViewStubService.i(this.pUR) == null || WebViewStubService.i(this.pUR).containsKey(muVar.bXK.filePath))) {
            if (WebViewStubService.i(this.pUR) != null) {
                WebViewStubService.i(this.pUR).remove(muVar.bXK.filePath);
            }
            x.d("MicroMsg.WebViewStubService", "result: " + muVar.bXK.result);
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.h(this.pUR)) {
                    webViewStubCallbackWrapper.pXx.e(muVar.bXK.filePath, muVar.bXK.result, muVar.bXK.bJr, muVar.bXK.bJs);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebViewStubService", e, "", new Object[0]);
            }
        }
        return false;
    }
}
