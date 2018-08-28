package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.R;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.model.q;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static boolean a(ch chVar, a aVar) {
        if (!bi.oW(aVar.url)) {
            wl wlVar = new wl();
            wr wrVar = new wr();
            vx vxVar = new vx();
            vxVar.UH(aVar.url);
            vxVar.UB(aVar.title);
            vxVar.UC(aVar.desc);
            vxVar.UK(aVar.thumbUrl);
            vxVar.UZ(aVar.bZN);
            vxVar.kX(true);
            vxVar.kY(true);
            vxVar.CF(5);
            xa xaVar = new xa();
            xaVar.VM(aVar.thumbUrl);
            wlVar.b(xaVar);
            wrVar.Vw(q.GF());
            wrVar.Vx(q.GF());
            wrVar.CO(3);
            wrVar.fU(bi.VF());
            wrVar.VC(aVar.bPS);
            wrVar.VD(aVar.url);
            chVar.bJF.title = vxVar.title;
            chVar.bJF.bJH = wlVar;
            chVar.bJF.type = 5;
            wlVar.a(wrVar);
            wlVar.rBI.add(vxVar);
            return true;
        }
        x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or wrapper is invalid");
        chVar.bJF.bJL = R.l.favorite_fail_argument_error;
        return false;
    }
}
