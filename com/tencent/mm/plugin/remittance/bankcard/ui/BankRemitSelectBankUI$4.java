package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.plugin.remittance.bankcard.model.b;
import com.tencent.mm.protocal.c.fg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.wallet_core.c.h.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class BankRemitSelectBankUI$4 implements a {
    final /* synthetic */ BankRemitSelectBankUI mwu;
    final /* synthetic */ h mwv;

    BankRemitSelectBankUI$4(BankRemitSelectBankUI bankRemitSelectBankUI, h hVar) {
        this.mwu = bankRemitSelectBankUI;
        this.mwv = hVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        List arrayList = new ArrayList();
        List<fg> list = this.mwv.mtZ.rFE;
        List<fg> list2 = this.mwv.mtZ.rFD;
        Comparator bVar = new b();
        if (!(list == null || list.isEmpty())) {
            x.i("MicroMsg.BankRemitSelectBankUI", "freq card count: %s", new Object[]{Integer.valueOf(list2.size())});
            for (fg fgVar : list) {
                d dVar = new d();
                dVar.tDT = "☆";
                dVar.data = fgVar;
                arrayList.add(dVar);
            }
        }
        if (!(list2 == null || list2.isEmpty())) {
            x.i("MicroMsg.BankRemitSelectBankUI", "card count: %s", new Object[]{Integer.valueOf(list2.size())});
            Collections.sort(list2, bVar);
            for (fg fgVar2 : list2) {
                if (!bi.oW(fgVar2.knE)) {
                    String str2;
                    if (bi.oW(fgVar2.rgg)) {
                        str2 = com.tencent.mm.plugin.remittance.bankcard.model.a.Kv(fgVar2.knE);
                    } else {
                        x.i("MicroMsg.BankRemitSelectBankUI", "use sort pingyin: %s", new Object[]{fgVar2.rgg});
                        str2 = fgVar2.rgg.toUpperCase().charAt(0);
                    }
                    d dVar2 = new d();
                    dVar2.tDT = str2;
                    dVar2.data = fgVar2;
                    arrayList.add(dVar2);
                }
            }
        }
        BankRemitSelectBankUI.a(this.mwu).dx(arrayList);
    }
}
