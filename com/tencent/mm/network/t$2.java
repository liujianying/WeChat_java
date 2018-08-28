package com.tencent.mm.network;

import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.x;

class t$2 extends bd<Object> {
    final /* synthetic */ t esu;
    final /* synthetic */ String esv;

    t$2(t tVar, String str) {
        this.esu = tVar;
        this.esv = str;
        super(1000, null, (byte) 0);
    }

    protected final Object run() {
        x.chR();
        IPxxLogic.onIPxx(this.esv, 0);
        return null;
    }
}
