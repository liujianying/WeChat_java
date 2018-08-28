package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.bankcard.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class BankRemitHistoryUI$5 implements a {
    final /* synthetic */ BankRemitHistoryUI mvI;
    final /* synthetic */ i mvJ;

    BankRemitHistoryUI$5(BankRemitHistoryUI bankRemitHistoryUI, i iVar) {
        this.mvI = bankRemitHistoryUI;
        this.mvJ = iVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        if (this.mvJ.mua.rNJ != null) {
            x.i("MicroMsg.BankRemitHistoryUI", "history size: %s", new Object[]{Integer.valueOf(this.mvJ.mua.rNJ.size())});
            if (this.mvJ.mua.rNJ.size() < this.mvJ.limit) {
                x.i("MicroMsg.BankRemitHistoryUI", "is last: %s", new Object[]{Integer.valueOf(BankRemitHistoryUI.f(this.mvI))});
                BankRemitHistoryUI.g(this.mvI);
                BankRemitHistoryUI.b(this.mvI).removeFooterView(BankRemitHistoryUI.h(this.mvI));
            }
            if (this.mvJ.mua.rNJ != null) {
                BankRemitHistoryUI.a(this.mvI, BankRemitHistoryUI.f(this.mvI) + this.mvJ.mua.rNJ.size());
                BankRemitHistoryUI.i(this.mvI).addAll(this.mvJ.mua.rNJ);
                BankRemitHistoryUI.j(this.mvI).notifyDataSetChanged();
                return;
            }
            return;
        }
        x.i("MicroMsg.BankRemitHistoryUI", "return history is null");
        BankRemitHistoryUI.g(this.mvI);
        BankRemitHistoryUI.b(this.mvI).removeFooterView(BankRemitHistoryUI.h(this.mvI));
    }
}
