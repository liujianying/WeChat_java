package com.tencent.mm.plugin.wallet_payu.bind.ui;

import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.sdk.platformtools.bi;

protected class WalletPayUCardElementUI$b {
    final /* synthetic */ WalletPayUCardElementUI pEt;
    boolean pEu;
    boolean pEv;
    boolean pEw;

    protected WalletPayUCardElementUI$b(WalletPayUCardElementUI walletPayUCardElementUI) {
        this.pEt = walletPayUCardElementUI;
    }

    protected final void bRi() {
        this.pEu = WalletPayUCardElementUI.c(this.pEt).ZF();
        this.pEv = WalletPayUCardElementUI.b(this.pEt).ZF();
        this.pEw = WalletPayUCardElementUI.a(this.pEt).ZF();
        if (!WalletPayUCardElementUI.e(this.pEt) || this.pEw) {
            WalletPayUCardElementUI.f(this.pEt).setVisibility(4);
        } else {
            WalletPayUCardElementUI.f(this.pEt).setVisibility(0);
            WalletPayUCardElementUI.f(this.pEt).setText(a$i.wallet_card_cvv_err_hint);
        }
        boolean z;
        if (!WalletPayUCardElementUI.g(this.pEt)) {
            z = false;
        } else if (!this.pEu) {
            WalletPayUCardElementUI.h(this.pEt).setVisibility(0);
            WalletPayUCardElementUI.h(this.pEt).setTextColor(this.pEt.getResources().getColor(c.red));
            WalletPayUCardElementUI.h(this.pEt).setText(a$i.wallet_card_bankcard_type_err_tips);
            z = false;
        } else if (!WalletPayUCardElementUI.d(this.pEt).containsKey(WalletPayUCardElementUI.c(this.pEt).getText()) || WalletPayUCardElementUI.i(this.pEt).contains(WalletPayUCardElementUI.c(this.pEt).getText())) {
            this.pEt.a(new NetScenePayUElementQuery(WalletPayUCardElementUI.c(this.pEt).getText()), false, false);
            WalletPayUCardElementUI.i(this.pEt).add(WalletPayUCardElementUI.c(this.pEt).getText());
            WalletPayUCardElementUI.h(this.pEt).setVisibility(0);
            WalletPayUCardElementUI.h(this.pEt).setTextColor(this.pEt.getResources().getColor(c.hint_text_color));
            WalletPayUCardElementUI.h(this.pEt).setText(this.pEt.getString(a$i.wallet_bind_querying_card_element_payu));
            z = true;
        } else {
            PayUBankcardElement payUBankcardElement = (PayUBankcardElement) WalletPayUCardElementUI.d(this.pEt).get(WalletPayUCardElementUI.c(this.pEt).getText());
            WalletPayUCardElementUI.h(this.pEt).setVisibility(0);
            if (bi.oW(payUBankcardElement.pEc)) {
                WalletPayUCardElementUI.h(this.pEt).setTextColor(this.pEt.getResources().getColor(c.red));
                WalletPayUCardElementUI.h(this.pEt).setText(payUBankcardElement.pEd);
                this.pEu = false;
                z = false;
            } else {
                WalletPayUCardElementUI.h(this.pEt).setTextColor(this.pEt.getResources().getColor(c.hint_text_color));
                WalletPayUCardElementUI.h(this.pEt).setText(payUBankcardElement.pEd);
                z = false;
            }
        }
        if (this.pEu && this.pEv && this.pEw && !z) {
            WalletPayUCardElementUI.j(this.pEt).setEnabled(true);
        } else {
            WalletPayUCardElementUI.j(this.pEt).setEnabled(false);
        }
    }
}
