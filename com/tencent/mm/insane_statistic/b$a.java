package com.tencent.mm.insane_statistic;

import com.tencent.mm.ab.b;
import com.tencent.mm.ak.e;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bd;

class b$a {
    bd bGS = null;
    final b diG;
    long dlN;
    int dlO;
    e dlP;
    String dlQ;
    boolean dlR = false;
    String dlS;
    int dlT = 0;
    keep_SceneResult dlU;
    boolean dlV = false;
    c dlW = new 1(this);
    c dlX = new 2(this);

    static /* synthetic */ void a(b$a b_a) {
        a.sFg.c(b_a.dlW);
        a.sFg.c(b_a.dlX);
    }

    b$a(long j, bd bdVar, b bVar, boolean z, int i) {
        this.dlN = j;
        this.bGS = bdVar;
        this.diG = bVar;
        this.dlO = i;
        this.dlV = z;
    }
}
