package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.h;
import com.tencent.mm.protocal.c.aci;
import com.tencent.mm.protocal.c.acj;
import com.tencent.mm.protocal.c.aqf;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c extends l implements k {
    private final b diG;
    private e diJ;

    public c() {
        a aVar = new a();
        aVar.dIG = new aci();
        aVar.dIH = new acj();
        aVar.uri = "/cgi-bin/micromsg-bin/getcontactlabellist";
        aVar.dIF = 639;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        int i4 = 0;
        x.d("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            au.HU();
            com.tencent.mm.model.c.DT().set(209408, Long.valueOf(System.currentTimeMillis()));
            acj acj = (acj) this.diG.dIE.dIL;
            if (!(acj == null || acj.rbV == null)) {
                LinkedList linkedList = acj.rbV;
                List arrayList = new ArrayList();
                int size = linkedList.size();
                while (i4 < size) {
                    aqf aqf = (aqf) linkedList.get(i4);
                    ad adVar = new ad();
                    adVar.field_labelID = aqf.rSH;
                    adVar.field_labelName = aqf.rSG;
                    adVar.field_labelPYFull = h.oI(aqf.rSG);
                    adVar.field_labelPYShort = h.oJ(aqf.rSG);
                    arrayList.add(adVar);
                    i4++;
                }
                com.tencent.mm.plugin.label.e.aYJ().dc(arrayList);
                com.tencent.mm.plugin.label.e.aYJ().dd(com.tencent.mm.plugin.label.e.aYJ().de(arrayList));
            }
        } else {
            x.w("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] getcontactlabellist fail.");
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 639;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
