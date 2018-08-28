package com.tencent.mm.plugin.readerapp.c;

import com.tencent.mm.g.a.ch;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.d;

public final class b {
    public static boolean a(ch chVar, bi biVar, int i) {
        if (chVar == null || biVar == null) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or readerAppInfo is null");
            if (chVar != null) {
                chVar.bJF.bJL = g.favorite_fail_argument_error;
            }
            return false;
        }
        String v;
        wl wlVar = new wl();
        wr wrVar = new wr();
        vx vxVar = new vx();
        wrVar.Vw("newsapp");
        wrVar.Vx(q.GF());
        wrVar.Vx(q.GF());
        wrVar.CO(1);
        wrVar.fU(biVar.dCR);
        wrVar.VA(biVar.dCW);
        wrVar.VD(biVar.getUrl());
        wrVar.VE("newsapp");
        vxVar.UT(String.valueOf(biVar.dCW));
        if (i == 0) {
            v = com.tencent.mm.pluginsdk.model.q.v(biVar.Iz(), biVar.type, "@T");
        } else {
            v = com.tencent.mm.pluginsdk.model.q.v(biVar.Iz(), biVar.type, "@S");
        }
        if (d.cn(v)) {
            vxVar.UQ(v);
        } else {
            vxVar.kY(true);
            vxVar.UK(biVar.Iz());
            xa xaVar = new xa();
            xaVar.VM(biVar.Iz());
            wlVar.b(xaVar);
        }
        vxVar.CF(5);
        vxVar.UB(biVar.getTitle());
        vxVar.UC(biVar.IA());
        vxVar.kX(true);
        wlVar.a(wrVar);
        wlVar.rBI.add(vxVar);
        chVar.bJF.desc = biVar.getTitle();
        chVar.bJF.bJH = wlVar;
        chVar.bJF.type = 5;
        return true;
    }
}
