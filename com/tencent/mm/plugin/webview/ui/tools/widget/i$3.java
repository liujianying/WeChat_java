package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.sdk.platformtools.bd;

class i$3 extends bd<String> {
    final /* synthetic */ i qkV;

    i$3(i iVar, String str) {
        this.qkV = iVar;
        super(1000, str, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        return this.qkV.dEn == null ? "" : this.qkV.dEn.getUrl();
    }
}
