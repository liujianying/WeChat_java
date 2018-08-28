package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class ac {
    public static d a(e eVar) {
        d dVar = null;
        if (eVar == null) {
            x.e("MicroMsg.GamePBData", "Invalid pb object");
        } else if (bi.oW(eVar.jPc)) {
            x.e("MicroMsg.GamePBData", "No AppID field, abort");
        } else {
            x.i("MicroMsg.GamePBData", "Parsing AppID: %s", new Object[]{eVar.jPc});
            dVar = new d();
            dVar.field_appId = eVar.jPc;
            dVar.field_appName = eVar.jPe;
            dVar.field_appIconUrl = eVar.jPd;
            dVar.field_appType = ",1,";
            dVar.field_packageName = eVar.jPg;
            dVar.field_appVersion = eVar.hcD;
            dVar.field_appInfoFlag = eVar.jPj;
            if (eVar.jPi != null) {
                dVar.di(eVar.jPi.jPS);
                dVar.dl(eVar.jPi.jPT);
                dVar.eA(eVar.jPi.jPW);
                dVar.dm(eVar.jPi.jPU);
                dVar.jLv = eVar.jPi.jPY;
                dVar.jLw = (long) eVar.jPi.jPX;
                dVar.bPG = eVar.jPi.jPZ;
            }
            if (!(eVar.jPi == null || eVar.jPi.jPV == null)) {
                dVar.dr(eVar.jPi.jPV.jPS);
                dVar.ds(eVar.jPi.jPV.jTz);
                dVar.dp(eVar.jPi.jPV.jTA);
                dVar.dq(eVar.jPi.jPV.jTB);
                dVar.eB(eVar.jPi.jPV.jTD);
            }
            dVar.jLc = eVar.jOS;
            dVar.jLb = eVar.jPf;
            dVar.status = eVar.hcd;
            dVar.jLe = eVar.jOX;
            dVar.versionCode = eVar.jPh;
            dVar.bHF = eVar.jOZ;
            dVar.jLg = eVar.jPk;
            dVar.jLo = eVar.jPp;
            if (!(eVar.jPi == null || eVar.jPi.jPV == null)) {
                dVar.jLh = eVar.jPi.jPV.jTC;
                dVar.jLi = eVar.jPi.jPV.jTE;
                dVar.jLj = eVar.jPi.jPV.jTF;
            }
            dVar.dPU = eVar.jPr;
            dVar.jLx = eVar.jPs;
        }
        return dVar;
    }
}
