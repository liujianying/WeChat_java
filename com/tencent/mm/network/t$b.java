package com.tencent.mm.network;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.network.j.a;

class t$b extends a implements l {
    private t cWB;
    private WakerLock esP;

    public t$b(t tVar, WakerLock wakerLock) {
        this.cWB = tVar;
        this.esP = wakerLock;
    }

    public final void a(r rVar, int i, int i2, String str) {
        this.esP.lock(1000, "MMAutoAuth.IOnGetCert.onAutoAuth");
        new 1(this, rVar, i, i2).a(this.cWB.handler);
    }

    public final void a(int i, int i2, int i3, String str, r rVar, byte[] bArr) {
    }
}
