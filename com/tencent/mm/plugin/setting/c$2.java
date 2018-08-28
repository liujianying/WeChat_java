package com.tencent.mm.plugin.setting;

import com.tencent.mm.ab.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Map;

class c$2 implements a {
    final /* synthetic */ c mOE;

    c$2(c cVar) {
        this.mOE = cVar;
    }

    public final void a(d.a aVar) {
        String a = ab.a(aVar.dIN.rcl);
        if (a == null || a.length() == 0) {
            x.e("MicroMsg.SubCoreSetting", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
            return;
        }
        Map z = bl.z(a, "sysmsg");
        if (z != null) {
            String aG = bi.aG((String) z.get(".sysmsg.RedPoints.redPoint.path"), "");
            int WU = bi.WU(bi.aG((String) z.get(".sysmsg.RedPoints.redPoint.redPointId"), ""));
            bi.WU(bi.aG((String) z.get(".sysmsg.RedPoints.redPoint.mustClearInSameTime"), ""));
            if (!bi.oW(aG)) {
                if (aG.equals("my_setting_privaty_recentOption")) {
                    if (((Integer) g.Ei().DT().get(aa.a.sWc, Integer.valueOf(0))).intValue() < WU) {
                        g.Ei().DT().a(aa.a.sWc, Integer.valueOf(WU));
                        g.Ei().DT().a(aa.a.sWd, Integer.valueOf(WU));
                        g.Ei().DT().a(aa.a.sWf, Integer.valueOf(WU));
                        g.Ei().DT().a(aa.a.sWh, Integer.valueOf(WU));
                        g.Ei().DT().a(aa.a.sWj, Integer.valueOf(WU));
                        c.Cp().v(266260, true);
                    }
                } else if (aG.equals("my_setting_plugin_switch")) {
                    String aG2 = bi.aG((String) z.get(".sysmsg.RedPoints.redPoint.ext"), "");
                    if (!bi.oW(aG2) && ((Integer) g.Ei().DT().get(aa.a.sXc, Integer.valueOf(0))).intValue() < WU) {
                        Object concat;
                        g.Ei().DT().a(aa.a.sXc, Integer.valueOf(WU));
                        a = (String) g.Ei().DT().get(aa.a.sXd, "");
                        if (bi.oW(a)) {
                            a = aG2;
                        } else {
                            concat = aG2.concat(",").concat(a);
                        }
                        g.Ei().DT().a(aa.a.sXd, concat);
                        c.Cp().v(262158, true);
                    }
                }
            }
        }
    }
}
