package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.mm.sdk.platformtools.bd;

class u$2 extends bd<Boolean> {
    final /* synthetic */ int Xt;
    final /* synthetic */ int fKG;
    final /* synthetic */ u goS;
    final /* synthetic */ int goT;
    final /* synthetic */ float[] goU;
    final /* synthetic */ boolean goV;
    final /* synthetic */ View val$view;

    u$2(u uVar, Boolean bool, View view, int i, int i2, float[] fArr, int i3, boolean z) {
        this.goS = uVar;
        this.val$view = view;
        this.fKG = i;
        this.goT = i2;
        this.goU = fArr;
        this.Xt = i3;
        this.goV = z;
        super(1000, bool, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        return Boolean.valueOf(this.goS.b(this.val$view, this.fKG, this.goT, this.goU, this.Xt, this.goV));
    }
}
