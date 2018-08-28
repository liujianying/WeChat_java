package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Map;

public final class d implements a {
    public final void a(com.tencent.mm.ab.d.a aVar) {
        x.i("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "receivemsg NewYearSNSAmountLevelCtrl2016NotifyLsn");
        b.kB(67);
        if (aVar == null || aVar.dIN == null) {
            x.e("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "onPreAddMessage cmdAM is null");
            return;
        }
        e eVar = new e();
        String a = ab.a(aVar.dIN.rcl);
        eVar.gVP = new StringBuffer();
        Map z = bl.z(a, "sysmsg");
        eVar.level = 0;
        if (z == null) {
            x.i("MicroMsg.NewYearSnsAmountLevel", "errr for paser %s", new Object[]{a});
            b.kB(68);
        } else {
            eVar.level = bi.WU((String) z.get(".sysmsg.NewYearSNSAmountLevelCtrl2016.Level"));
            x.i("MicroMsg.NewYearSnsAmountLevel", "get level %d", new Object[]{Integer.valueOf(eVar.level)});
            if (eVar.level == 0) {
                b.kB(69);
            } else if (eVar.level == 1) {
                b.kB(70);
            } else if (eVar.level == 2) {
                b.kB(71);
            } else if (eVar.level == 3) {
                b.kB(72);
            } else if (eVar.level == 4) {
                b.kB(73);
            }
        }
        x.i("MicroMsg.NewYearSnsAmountLevel", "dump NewYearSnsAmountLevel " + eVar.gVP.toString());
        g.Ek();
        g.Ei().DT().a(aa.a.sSD, a);
        g.Ek();
        g.Ei().DT().lm(true);
    }
}
