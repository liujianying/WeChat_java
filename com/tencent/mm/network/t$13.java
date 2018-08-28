package com.tencent.mm.network;

import com.tencent.mars.BaseEvent;
import com.tencent.mm.sdk.platformtools.bd;

class t$13 extends bd<Object> {
    final /* synthetic */ t esu;

    t$13(t tVar, Object obj) {
        this.esu = tVar;
        super(3000, obj, (byte) 0);
    }

    public final Object run() {
        BaseEvent.onNetworkChange();
        return null;
    }
}
