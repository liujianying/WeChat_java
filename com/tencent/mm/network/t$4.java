package com.tencent.mm.network;

import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.sdk.platformtools.bd;

class t$4 extends bd<Object> {
    final /* synthetic */ t esu;
    final /* synthetic */ String[] esw;
    final /* synthetic */ String[] esx;
    final /* synthetic */ int[] esy;

    t$4(t tVar, String[] strArr, String[] strArr2, int[] iArr) {
        this.esu = tVar;
        this.esw = strArr;
        this.esx = strArr2;
        this.esy = iArr;
        super(1000, null, (byte) 0);
    }

    protected final Object run() {
        MMLogic.setHostInfo(this.esw, this.esx, this.esy);
        return null;
    }
}
