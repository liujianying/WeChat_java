package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.bd;

class b$1 extends bd<Boolean> {
    final /* synthetic */ int Xt;
    final /* synthetic */ int fKG;
    final /* synthetic */ int goT = 0;
    final /* synthetic */ float[] goU;
    final /* synthetic */ b pQL;
    final /* synthetic */ View val$view;

    public b$1(b bVar, Boolean bool, View view, int i, float[] fArr, int i2) {
        this.pQL = bVar;
        this.val$view = view;
        this.fKG = i;
        this.goU = fArr;
        this.Xt = i2;
        super(1000, bool, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        return Boolean.valueOf(this.pQL.a(this.val$view, this.fKG, this.goT, this.goU, this.Xt));
    }
}
