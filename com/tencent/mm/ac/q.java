package com.tencent.mm.ac;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.bf;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.pd;
import com.tencent.mm.protocal.c.pe;
import com.tencent.mm.protocal.c.pf;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class q extends l implements k {
    private b diG;
    private e diJ;

    public q(String str, int i, String str2, LinkedList<pd> linkedList) {
        a aVar = new a();
        aVar.dIG = new pe();
        aVar.dIH = new pf();
        aVar.uri = "/cgi-bin/micromsg-bin/clickcommand";
        aVar.dIF = 359;
        aVar.dII = 176;
        aVar.dIJ = 1000000176;
        this.diG = aVar.KT();
        pe peVar = (pe) this.diG.dID.dIL;
        peVar.rtz = i;
        peVar.rtA = str2;
        peVar.riA = str;
        peVar.rco = bf.Ir();
        if (linkedList != null) {
            peVar.rtB = linkedList;
        }
        x.i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s, MsgReport size %d", new Object[]{str, Integer.valueOf(i), str2, peVar.rco, Integer.valueOf(peVar.rtB.size())});
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 359;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
