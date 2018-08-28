package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.g.a.sg;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.ayv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class i extends c<sg> {
    public i() {
        this.sFo = sg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        List list = ((sg) bVar).cdb.cdc;
        if (list == null || list.size() <= 0) {
            x.e("MicroMsg.UpdateMassSendPlaceTopListener", "empty mass send top config package");
        } else {
            byte[] a = ab.a(((ayv) list.get(0)).rdp);
            if (!(a == null || a.length == 0)) {
                String str = new String(a);
                x.i("MicroMsg.UpdateMassSendPlaceTopListener", "MassSendTopConfXml:" + str);
                h.bcp().Gj(str);
            }
        }
        return false;
    }
}
