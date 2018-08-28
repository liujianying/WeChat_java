package com.tencent.mm.network;

import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.sdk.platformtools.bd;

class t$11 extends bd<Object> {
    final /* synthetic */ String esM;
    final /* synthetic */ String esN;
    final /* synthetic */ t esu;

    t$11(t tVar, String str, String str2) {
        this.esu = tVar;
        this.esM = str;
        this.esN = str2;
        super(1000, null, (byte) 0);
    }

    protected final Object run() {
        MMLogic.setNewDnsDebugHost(this.esM, this.esN);
        return null;
    }
}
