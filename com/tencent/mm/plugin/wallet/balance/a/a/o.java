package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class o {
    public static int oZi = 123;
    public static int oZj = 456;
    public int accountType;
    public String bOe;
    public b eAc;
    private m oZk = null;
    public n oZl = null;
    public WalletLqtSaveFetchUI oZm = null;
    public String oZn;
    public int oZo;
    public int oZp;
    public String oZq;
    public Bankcard oZr;

    static /* synthetic */ void a(o oVar, String str, Bankcard bankcard) {
        if (bankcard == null) {
            bankcard = oVar.oZr;
        }
        oVar.eAc = g.cBF();
        oVar.eAc.cBE();
        h.a(oVar.oZm, bankcard != null ? bankcard.field_bindSerial : "", str, "", oVar.accountType == 0 ? 45 : 52, oZi);
    }

    public o(m mVar, n nVar, WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        this.oZk = mVar;
        this.oZl = nVar;
        this.oZm = walletLqtSaveFetchUI;
    }
}
