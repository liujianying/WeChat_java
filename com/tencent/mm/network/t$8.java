package com.tencent.mm.network;

import com.tencent.mars.BaseEvent;
import com.tencent.mm.af.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bd;

class t$8 extends bd<Object> {
    final /* synthetic */ boolean esD;
    final /* synthetic */ t esu;

    t$8(t tVar, Object obj, boolean z) {
        this.esu = tVar;
        this.esD = z;
        super(3000, obj, (byte) 0);
    }

    public final Object run() {
        BaseEvent.onForeground(this.esD);
        a.bI(this.esD);
        b.bB(this.esD);
        return null;
    }
}
