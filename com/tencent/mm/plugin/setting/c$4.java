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
import java.text.SimpleDateFormat;
import java.util.Map;

class c$4 implements a {
    final /* synthetic */ c mOE;

    c$4(c cVar) {
        this.mOE = cVar;
    }

    public final void a(d.a aVar) {
        String a = ab.a(aVar.dIN.rcl);
        if (a == null || a.length() == 0) {
            x.e("MicroMsg.SubCoreSetting", "onReceiveMsg, crowdtest msgContent is null");
            return;
        }
        Map z = bl.z(a, "sysmsg");
        if (z != null) {
            int i = bi.getInt((String) z.get(".sysmsg.crowdtest.$clientversion"), 0);
            if (i > com.tencent.mm.protocal.d.qVN) {
                long j = 0;
                try {
                    j = new SimpleDateFormat("yyyy-MM-dd").parse((String) z.get(".sysmsg.crowdtest.apply.$expire")).getTime();
                } catch (Exception e) {
                }
                if (j < System.currentTimeMillis()) {
                    c.btp();
                    return;
                }
                a = (String) z.get(".sysmsg.crowdtest.apply.link");
                String str = (String) z.get(".sysmsg.crowdtest.feedback.link");
                g.Ei().DT().a(aa.a.sWY, Integer.valueOf(i));
                g.Ei().DT().a(aa.a.sWZ, Long.valueOf(j));
                g.Ei().DT().a(aa.a.sXa, a);
                g.Ei().DT().a(aa.a.sXb, str);
                int i2 = bi.getInt((String) z.get(".sysmsg.crowdtest.apply.reddotlevel"), 0);
                c.Cp().v(262157, i2 > 0);
                if (i2 < 3) {
                    c.Cp().aV(262157, 266261);
                }
                if (i2 < 2) {
                    c.Cp().aV(262157, 266262);
                }
            }
        }
    }
}
