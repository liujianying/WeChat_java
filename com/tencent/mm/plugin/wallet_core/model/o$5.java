package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.g.a.sg;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.ayv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class o$5 extends c<sg> {
    final /* synthetic */ o pqJ;

    o$5(o oVar) {
        this.pqJ = oVar;
        this.sFo = sg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sg sgVar = (sg) bVar;
        if (sgVar.cdb.bJE == 11) {
            List list = sgVar.cdb.cdc;
            if (list == null || list.size() <= 0) {
                x.e("MicroMsg.UpdateMassSendPlaceTopListener", "empty UpdatePackageEvent");
            } else {
                byte[] a = ab.a(((ayv) list.get(0)).rdp);
                if (!(a == null || a.length == 0)) {
                    String str = new String(a);
                    if (str.equals(o.a(this.pqJ))) {
                        x.i("MicroMsg.UpdateMassSendPlaceTopListener", "the same result : %s" + str);
                    } else {
                        x.i("MicroMsg.UpdateMassSendPlaceTopListener", "UpdatePackageEvent: %s", new Object[]{str});
                        com.tencent.mm.plugin.wallet_core.d.b.Pi(str);
                        o.a(this.pqJ, str);
                    }
                }
            }
        }
        return false;
    }
}
