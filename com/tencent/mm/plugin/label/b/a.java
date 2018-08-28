package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.h;
import com.tencent.mm.protocal.c.aqf;
import com.tencent.mm.protocal.c.bp;
import com.tencent.mm.protocal.c.bq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends l implements k {
    private final b diG;
    private e diJ;
    private LinkedList<aqf> kAE = new LinkedList();

    public a(String str) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bp();
        aVar.dIH = new bq();
        aVar.uri = "/cgi-bin/micromsg-bin/addcontactlabel";
        aVar.dIF = 635;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        if (!bi.oW(str)) {
            aqf aqf = new aqf();
            aqf.rSG = str;
            this.kAE.add(aqf);
        }
    }

    public a(List<String> list) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bp();
        aVar.dIH = new bq();
        aVar.uri = "/cgi-bin/micromsg-bin/addcontactlabel";
        aVar.dIF = 635;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                aqf aqf = new aqf();
                aqf.rSG = (String) list.get(i);
                this.kAE.add(aqf);
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene].");
        this.diJ = eVar2;
        bp bpVar = (bp) this.diG.dID.dIL;
        if (this.kAE == null || this.kAE.size() <= 0) {
            x.e("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene] label list is null.");
            eVar2.a(3, -1, "[doScene]empty contact list.", this);
            return 0;
        }
        bpVar.rbV = this.kAE;
        bpVar.rbU = this.kAE.size();
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        bq aYL = aYL();
        if (aYL != null) {
            LinkedList linkedList = aYL.rbV;
            List arrayList = new ArrayList();
            int size = linkedList.size();
            for (int i4 = 0; i4 < size; i4++) {
                aqf aqf = (aqf) linkedList.get(i4);
                ad adVar = new ad();
                adVar.field_labelID = aqf.rSH;
                adVar.field_labelName = aqf.rSG;
                adVar.field_labelPYFull = h.oI(aqf.rSG);
                adVar.field_labelPYShort = h.oJ(aqf.rSG);
                adVar.field_isTemporary = false;
                arrayList.add(adVar);
            }
            com.tencent.mm.plugin.label.e.aYJ().db(arrayList);
            com.tencent.mm.plugin.label.e.aYJ().dc(arrayList);
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 635;
    }

    public final bq aYL() {
        return (bq) this.diG.dIE.dIL;
    }
}
