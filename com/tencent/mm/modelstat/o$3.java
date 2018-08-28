package com.tencent.mm.modelstat;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.protocal.c.bfj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class o$3 implements a {
    final /* synthetic */ long ekP;
    final /* synthetic */ bfj ekQ;

    o$3(long j, bfj bfj) {
        this.ekP = j;
        this.ekQ = bfj;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(bi.bH(this.ekP)), this.ekQ.mEl);
        return 0;
    }
}
