package com.tencent.mm.plugin.zero;

import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.by.a.a;
import com.tencent.mm.plugin.zero.PluginZero.b;
import com.tencent.mm.plugin.zero.a.c;

class PluginZero$b$1 implements a<c> {
    final /* synthetic */ NotifyService qxN;
    final /* synthetic */ int qxO;
    final /* synthetic */ byte[] qxP;
    final /* synthetic */ byte[] qxQ;
    final /* synthetic */ long qxR;
    final /* synthetic */ b qxS;

    PluginZero$b$1(b bVar, NotifyService notifyService, int i, byte[] bArr, byte[] bArr2, long j) {
        this.qxS = bVar;
        this.qxN = notifyService;
        this.qxO = i;
        this.qxP = bArr;
        this.qxQ = bArr2;
        this.qxR = j;
    }

    public final /* synthetic */ void aD(Object obj) {
        ((c) obj).a(this.qxN, this.qxO, this.qxP, this.qxQ, this.qxR);
    }
}
