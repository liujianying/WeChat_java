package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ai;
import com.tencent.mm.protocal.c.blm;
import com.tencent.mm.protocal.c.bln;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class k extends l implements com.tencent.mm.network.k {
    private final b diG;
    private e diJ;

    public k(List<ix> list) {
        a aVar = new a();
        aVar.dIG = new blm();
        aVar.dIH = new bln();
        aVar.uri = "/cgi-bin/micromsg-bin/setapplist";
        aVar.dIF = 386;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        blm blm = (blm) this.diG.dID.dIL;
        LinkedList linkedList = new LinkedList();
        for (ix ixVar : list) {
            ai aiVar = new ai();
            aiVar.hbL = ixVar.userName;
            linkedList.add(aiVar);
        }
        blm.hbF = linkedList.size();
        blm.hbG = linkedList;
        x.i("MicroMsg.BrandService.NetSceneSetAppList", "info: upload size %d, toString %s", new Object[]{Integer.valueOf(linkedList.size()), linkedList.toString()});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.BrandService.NetSceneSetAppList", "on scene end code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.BrandService.NetSceneSetAppList", "ok, hash code is %d", new Object[]{Integer.valueOf(((bln) this.diG.dIE.dIL).rEY)});
            com.tencent.mm.plugin.brandservice.a.g(196610, Integer.valueOf(r0.rEY));
            com.tencent.mm.plugin.brandservice.a.g(196611, Boolean.valueOf(false));
        } else {
            com.tencent.mm.plugin.brandservice.a.g(196611, Boolean.valueOf(true));
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 386;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.BrandService.NetSceneSetAppList", "do scene");
        return a(eVar, this.diG, this);
    }
}
