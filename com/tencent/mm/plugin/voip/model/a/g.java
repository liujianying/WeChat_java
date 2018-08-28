package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.model.q;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.cad;
import com.tencent.mm.protocal.c.cae;
import com.tencent.mm.protocal.c.cak;
import java.util.LinkedList;
import java.util.List;

public final class g extends n<cad, cae> {
    public g(List<String> list, byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        a aVar = new a();
        aVar.dIG = new cad();
        aVar.dIH = new cae();
        aVar.uri = "/cgi-bin/micromsg-bin/voipinvite";
        aVar.dIF = 170;
        aVar.dII = 63;
        aVar.dIJ = 1000000063;
        this.diG = aVar.KT();
        cad cad = (cad) this.diG.dID.dIL;
        LinkedList linkedList = new LinkedList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            linkedList.add(new bhz().VO((String) list.get(i4)));
        }
        cad.seC = q.GF();
        cad.svW = linkedList;
        cad.svV = linkedList.size();
        cad.rth = i;
        cad.soz = 0;
        cad.svK = i2;
        cad.sef = i3;
        cak cak = new cak();
        cak.hcE = 2;
        bhy bhy = new bhy();
        bhy.bq(bArr);
        cak.rfy = bhy;
        cad.suK = cak;
        cak = new cak();
        cak.hcE = 3;
        bhy = new bhy();
        bhy.bq(bArr2);
        cak.rfy = bhy;
        cad.suL = cak;
        cad.suO = System.currentTimeMillis();
    }

    public final int getType() {
        return 170;
    }

    public final e bLm() {
        return new 1(this);
    }
}
