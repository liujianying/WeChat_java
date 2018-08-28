package com.tencent.mm.network;

import com.tencent.mars.stn.StnLogic;
import com.tencent.mm.sdk.platformtools.bd;

class t$12 extends bd<Object> {
    final /* synthetic */ String esM;
    final /* synthetic */ String esO;
    final /* synthetic */ t esu;

    public t$12(t tVar, String str, String str2) {
        this.esu = tVar;
        this.esO = str;
        this.esM = str2;
        super(1000, null, (byte) 0);
    }

    protected final Object run() {
        StnLogic.setDebugIP(this.esO, this.esM);
        return null;
    }
}
