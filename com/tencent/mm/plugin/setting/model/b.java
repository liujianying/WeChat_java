package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bud;
import com.tencent.mm.protocal.c.cc;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class b extends l implements k {
    private e diJ;
    private List<String> iKk;

    public b(List<String> list) {
        this.iKk = list;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.dIZ = i;
        if (!(i2 == 0 && i3 == 0)) {
            x.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 583;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        a aVar = new a();
        cc ccVar = new cc();
        Collection arrayList = new ArrayList();
        if (this.iKk != null) {
            for (int i = 0; i < this.iKk.size(); i++) {
                bud bud = new bud();
                bud.hbL = (String) this.iKk.get(i);
                arrayList.add(bud);
            }
        }
        ccVar.rcx.addAll(arrayList);
        aVar.dIG = ccVar;
        aVar.dIH = new cd();
        aVar.uri = "/cgi-bin/micromsg-bin/addtrustedfriends";
        aVar.dIF = 583;
        aVar.dII = 0;
        aVar.dII = 0;
        return a(eVar, aVar.KT(), this);
    }
}
