package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ab.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.protocal.c.bfs;
import com.tencent.mm.protocal.c.bft;
import com.tencent.mm.wallet_core.c.d;

public final class h extends a<bft> implements d {
    public h(int i, String str, String str2, int i2) {
        b.a aVar = new b.a();
        aVar.dIG = new bfs();
        aVar.dIH = new bft();
        aVar.dIF = 1338;
        aVar.uri = "/cgi-bin/mmpay-bin/redeemfund";
        aVar.dII = 0;
        aVar.dIJ = 0;
        b KT = aVar.KT();
        bfs bfs = (bfs) KT.dID.dIL;
        bfs.sdC = i;
        bfs.rtJ = str;
        bfs.sdF = str2;
        bfs.rtK = i2;
        this.diG = KT;
    }
}
