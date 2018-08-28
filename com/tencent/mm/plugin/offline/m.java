package com.tencent.mm.plugin.offline;

import com.tencent.mm.g.a.to;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s$f;
import com.tencent.mm.plugin.offline.a.s.a;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

public final class m implements a {
    c kRJ = new 1(this);

    public m() {
        com.tencent.mm.sdk.b.a.sFg.b(this.kRJ);
        k.bkO();
        k.bkP().a(this);
    }

    private static void ax(int i, String str) {
        to toVar = new to();
        toVar.cfd.cff = i;
        toVar.cfd.action = 4;
        toVar.cfd.content = str;
        com.tencent.mm.sdk.b.a.sFg.m(toVar);
    }

    public final boolean a(s.c cVar) {
        if (cVar.lKD == 6) {
            s$f s_f = (s$f) cVar;
            if (s_f.lKL.ppf == null || s_f.lKL.ppf.size() <= 0) {
                ax(9, ad.getContext().getString(i.wallet_wear_pay_error));
            } else {
                Commodity commodity = (Commodity) s_f.lKL.ppf.get(0);
                ax(0, ad.getContext().getString(i.wallet_wear_pay_result_info, new Object[]{e.e(commodity.hUL, commodity.lNV)}));
            }
        } else if (cVar.lKD == 8) {
            ax(6, ad.getContext().getString(i.wallet_wear_pay_error));
        } else if (cVar.lKD == 5) {
            ax(7, bi.aG(((s.e) cVar).lKH, ""));
        } else if (cVar.lKD == 4) {
            ax(8, ad.getContext().getString(i.wallet_wear_pay_freeze_error));
        }
        return false;
    }
}
