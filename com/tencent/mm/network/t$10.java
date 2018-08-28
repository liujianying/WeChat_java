package com.tencent.mm.network;

import com.tencent.mars.BaseEvent;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.sdk.platformtools.bd;

class t$10 extends bd<Object> {
    final /* synthetic */ String esI;
    final /* synthetic */ String esJ;
    final /* synthetic */ String esK;
    final /* synthetic */ String esL;
    final /* synthetic */ t esu;

    t$10(t tVar, Object obj, String str, String str2, String str3, String str4) {
        this.esu = tVar;
        this.esI = str;
        this.esJ = str2;
        this.esK = str3;
        this.esL = str4;
        super(3000, obj, (byte) 0);
    }

    public final Object run() {
        MMLogic.setDebugIP(this.esI, this.esJ, this.esK, this.esL);
        BaseEvent.onNetworkChange();
        return null;
    }
}
