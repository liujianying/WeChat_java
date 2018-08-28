package com.tencent.mm.plugin.aa;

import com.tencent.mm.ab.d.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Map;

class b$5 implements n {
    final /* synthetic */ b ezx;

    b$5(b bVar) {
        this.ezx = bVar;
    }

    public final void onNewXmlReceived(String str, Map<String, String> map, a aVar) {
        x.d("MicroMsg.SubCoreAA", "paymsgtype: %d, current version: %d", new Object[]{Integer.valueOf(bi.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0)), Integer.valueOf(d.qVN)});
        if (bi.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0) == 32) {
            int i = bi.getInt((String) map.get(".sysmsg.paymsg.receiveorpayreddot"), 0);
            int i2 = bi.getInt((String) map.get(".sysmsg.paymsg.grouppayreddot"), 0);
            int i3 = bi.getInt((String) map.get(".sysmsg.paymsg.facingreceivereddot"), 0);
            int i4 = bi.getInt((String) map.get(".sysmsg.paymsg.f2fhongbaoreddot"), 0);
            int i5 = bi.getInt((String) map.get(".sysmsg.paymsg.rewardcodereddot"), 0);
            int i6 = bi.getInt((String) map.get(".sysmsg.paymsg.android_minclientversion"), 0);
            String aG = bi.aG((String) map.get(".sysmsg.paymsg.facingreceivereddotwording"), "");
            g.Ek();
            g.Ei().DT().a(aa.a.sYu, aG);
            if (d.qVN >= i6) {
                boolean z;
                if (i == 1) {
                    x.i("MicroMsg.SubCoreAA", "mark recv or pay red dot");
                    c.Cp().v(262159, true);
                    z = true;
                } else {
                    z = false;
                }
                if (i2 == 1) {
                    x.i("MicroMsg.SubCoreAA", "mark group pay red dot");
                    c.Cp().b(aa.a.sZc, true);
                    z = true;
                }
                if (i3 == 1) {
                    x.i("MicroMsg.SubCoreAA", "mark f2f recv red dot");
                    c.Cp().b(aa.a.sZd, true);
                    z = true;
                }
                if (i4 == 1) {
                    x.i("MicroMsg.SubCoreAA", "mark f2f hb red dot");
                    c.Cp().b(aa.a.sZe, true);
                    z = true;
                }
                if (i5 == 1) {
                    x.i("MicroMsg.SubCoreAA", "mark qr reward red dot");
                    c.Cp().b(aa.a.sZf, true);
                    z = true;
                }
                if (z) {
                    g.Ei().DT().a(aa.a.sZh, Boolean.valueOf(false));
                }
            }
            h.mEJ.h(14396, new Object[]{Integer.valueOf(1)});
        }
    }
}
