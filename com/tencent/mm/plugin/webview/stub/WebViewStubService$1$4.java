package com.tencent.mm.plugin.webview.stub;

import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.stub.WebViewStubService.1;
import com.tencent.mm.sdk.platformtools.bd;

class WebViewStubService$1$4 extends bd<String> {
    final /* synthetic */ String dhm;
    final /* synthetic */ 1 pUU;

    WebViewStubService$1$4(1 1, String str) {
        this.pUU = 1;
        this.dhm = str;
        super(1000, null, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        return au.HX() ? g.AT().getValue(this.dhm) : null;
    }
}
