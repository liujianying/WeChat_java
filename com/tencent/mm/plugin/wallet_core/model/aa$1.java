package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class aa$1 implements a {
    final /* synthetic */ aa prd;

    aa$1(aa aaVar) {
        this.prd = aaVar;
    }

    public final void a(d.a aVar) {
        String a = ab.a(aVar.dIN.rcl);
        x.d("MicroMsg.WalletPushNotifyManager", "PayMsg:" + a);
        Map z = bl.z(a, "sysmsg");
        int i = bi.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
        if (!aa.a(this.prd, i, z)) {
            aa.d(i, z);
        }
    }
}
