package com.tencent.mm.plugin.webview.fts.ui;

import com.tencent.mm.sdk.platformtools.bd;

class b$5 extends bd<Boolean> {
    final /* synthetic */ int fKG;
    final /* synthetic */ b pQL;

    public b$5(b bVar, Boolean bool, int i) {
        this.pQL = bVar;
        this.fKG = i;
        super(1000, bool, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        return Boolean.valueOf(this.pQL.lB(this.fKG));
    }
}
