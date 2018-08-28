package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.ab.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class o$7 implements a {
    final /* synthetic */ o pqJ;

    o$7(o oVar) {
        this.pqJ = oVar;
    }

    public final void a(d.a aVar) {
        Map z = bl.z(ab.a(aVar.dIN.rcl), "sysmsg");
        if (z != null) {
            int i = bi.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
            x.i("MicroMsg.SubCoreWalletCore", "got a pay msg, type = " + i);
            switch (i) {
                case 16:
                    i = bi.getInt((String) z.get(".sysmsg.paymsg.Flag"), 0);
                    x.i("MicroMsg.SubCoreWalletCore", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=" + i);
                    if (i == 1) {
                        x.i("MicroMsg.SubCoreWalletCore", "open wallet");
                        q.GP();
                        return;
                    } else if (i == 2) {
                        x.i("MicroMsg.SubCoreWalletCore", "close wallet");
                        i = q.GL() & -32769;
                        g.Ek();
                        g.Ei().DT().set(40, Integer.valueOf(i));
                        return;
                    } else {
                        return;
                    }
                case 17:
                    i = bi.getInt((String) z.get(".sysmsg.paymsg.WalletType"), -1);
                    x.i("MicroMsg.SubCoreWalletCore", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=" + i);
                    if (i >= 0) {
                        g.Ek();
                        g.Ei().DT().set(339975, Integer.valueOf(i));
                        return;
                    }
                    return;
                case s$l.AppCompatTheme_actionModeFindDrawable /*37*/:
                    x.i("MicroMsg.SubCoreWalletCore", "receive c2c content update msg: %s", new Object[]{r1});
                    g.Ek();
                    g.Em().H(new 1(this, z));
                    return;
                default:
                    return;
            }
        }
    }
}
