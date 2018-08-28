package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.a.a.o.4;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.c.bdm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class p$c implements e<bdm, d<Integer, Integer, Bankcard>> {
    final /* synthetic */ p oZz;

    public p$c(p pVar) {
        this.oZz = pVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        d dVar = (d) obj;
        o oVar = this.oZz.oZu;
        int intValue = ((Integer) dVar.get(0)).intValue();
        int intValue2 = ((Integer) dVar.get(1)).intValue();
        Bankcard bankcard = (Bankcard) dVar.get(2);
        String str = "MicroMsg.LqtSaveFetchLogic";
        String str2 = "saveLqt, accountType: %s, bankcard: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(intValue2);
        objArr[1] = bankcard != null ? bankcard.field_bindSerial : "";
        x.i(str, str2, objArr);
        x.d("MicroMsg.LqtSaveFetchLogic", "saveLqt, amount: %s", new Object[]{Integer.valueOf(intValue)});
        String stringExtra = oVar.oZm.getIntent().getStringExtra("lqt_save_fund_code");
        str = oVar.oZm.getIntent().getStringExtra("lqt_fund_spid");
        oVar.oZo = intValue;
        oVar.accountType = intValue2;
        oVar.oZm.jh(true);
        g.a(g.a(stringExtra, str, Integer.valueOf(intValue), Integer.valueOf(intValue2)).c(oVar.oZl.oZd).c(new 4(oVar)).c(new o$3(oVar, bankcard)).a(new o$1(oVar)));
        return null;
    }

    public final String xr() {
        return "Vending.UI";
    }
}
