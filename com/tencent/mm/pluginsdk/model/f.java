package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.bi;

public final class f implements ad {
    public final boolean a(ch chVar, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        wl wlVar = new wl();
        wr wrVar = new wr();
        vx vxVar = new vx();
        vxVar.CF(5);
        vxVar.UQ(str7);
        vxVar.UH(str3);
        vxVar.CE(i);
        vxVar.UB(str);
        vxVar.UC(str2);
        vxVar.UZ(str11);
        wa waVar = new wa();
        waVar.dyL = str;
        waVar.rBq = i;
        waVar.dyJ = str3;
        waVar.dyN = str5;
        waVar.dyM = str4;
        waVar.dyO = str6;
        waVar.dyP = str9;
        waVar.dyQ = str10;
        vxVar.a(waVar);
        wrVar.Vw(str8);
        wrVar.Vx(q.GF());
        wrVar.CO(0);
        wrVar.fU(bi.VF());
        wlVar.a(wrVar);
        wlVar.rBI.add(vxVar);
        chVar.bJF.title = vxVar.title;
        chVar.bJF.desc = vxVar.title;
        chVar.bJF.bJH = wlVar;
        chVar.bJF.type = 4;
        return true;
    }

    public final boolean a(ch chVar, Intent intent) {
        return e.a(chVar, intent);
    }

    public final boolean a(ch chVar, String str) {
        return e.a(chVar, 2, str);
    }

    public final boolean a(ch chVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String format = String.format("%s#%s", new Object[]{str, ""});
        wl wlVar = new wl();
        wr wrVar = new wr();
        wrVar.Vw(str2);
        wrVar.CO(2);
        wrVar.fU(System.currentTimeMillis());
        wrVar.VB(str);
        wrVar.Vy(format);
        vx vxVar = new vx();
        vxVar.UT(format);
        vxVar.kY(true);
        vxVar.CF(5);
        vxVar.UB(str3);
        vxVar.UC(str4);
        vxVar.Va(str5);
        vxVar.kX(true);
        wlVar.rBI.add(vxVar);
        xa xaVar = new xa();
        xaVar.VM(str6);
        xaVar.VL(str7);
        wlVar.b(xaVar);
        wlVar.a(wrVar);
        chVar.bJF.bJH = wlVar;
        chVar.bJF.desc = str3;
        chVar.bJF.type = 5;
        return true;
    }
}
