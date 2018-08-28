package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.wallet.balance.a.a.l;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.awx;

class WalletLqtSaveFetchUI$6 implements TextWatcher {
    final /* synthetic */ WalletLqtSaveFetchUI pcc;

    WalletLqtSaveFetchUI$6(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        this.pcc = walletLqtSaveFetchUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (editable.toString().startsWith(".")) {
            editable.insert(0, "0");
        }
        String obj = editable.toString();
        int indexOf = obj.indexOf(".");
        int length = obj.length();
        if (indexOf >= 0 && length - indexOf > 3) {
            editable.delete(indexOf + 3, length);
        } else if (indexOf > 12) {
            editable.delete(12, indexOf);
        } else if (indexOf == -1 && length > 12) {
            editable.delete(12, length);
        }
        int fb = WalletLqtSaveFetchUI.fb(editable.toString(), "100");
        if (fb <= 0) {
            if (WalletLqtSaveFetchUI.g(this.pcc) != 1 || (WalletLqtSaveFetchUI.d(this.pcc) != null && WalletLqtSaveFetchUI.d(this.pcc).bOs())) {
                WalletLqtSaveFetchUI.l(this.pcc).setText(WalletLqtSaveFetchUI.m(this.pcc));
            } else {
                WalletLqtSaveFetchUI.l(this.pcc).setText("");
            }
            WalletLqtSaveFetchUI.l(this.pcc).setTextColor(Color.parseColor("#888888"));
            WalletLqtSaveFetchUI.b(this.pcc, false);
            WalletLqtSaveFetchUI.a(this.pcc, false);
        } else if (WalletLqtSaveFetchUI.g(this.pcc) == 1) {
            if (WalletLqtSaveFetchUI.d(this.pcc) == null) {
                WalletLqtSaveFetchUI.b(this.pcc, true);
                WalletLqtSaveFetchUI.a(this.pcc, true);
            } else if (WalletLqtSaveFetchUI.d(this.pcc).bOs()) {
                if (WalletLqtSaveFetchUI.b(this.pcc) == null || fb <= WalletLqtSaveFetchUI.fb(WalletLqtSaveFetchUI.b(this.pcc).plV, "100")) {
                    WalletLqtSaveFetchUI.l(this.pcc).setText(WalletLqtSaveFetchUI.m(this.pcc));
                    WalletLqtSaveFetchUI.l(this.pcc).setTextColor(Color.parseColor("#888888"));
                    WalletLqtSaveFetchUI.b(this.pcc, true);
                    WalletLqtSaveFetchUI.a(this.pcc, true);
                    return;
                }
                WalletLqtSaveFetchUI.l(this.pcc).setText(this.pcc.getString(i.wallet_lqt_save_balance_not_enough_hint));
                WalletLqtSaveFetchUI.l(this.pcc).setTextColor(-65536);
                WalletLqtSaveFetchUI.b(this.pcc, false);
                WalletLqtSaveFetchUI.a(this.pcc, false);
            } else if (WalletLqtSaveFetchUI.d(this.pcc).field_dayQuotaKind <= 0.0d || fb <= WalletLqtSaveFetchUI.fb(WalletLqtSaveFetchUI.d(this.pcc).field_dayQuotaKind, "100")) {
                WalletLqtSaveFetchUI.l(this.pcc).setText("");
                WalletLqtSaveFetchUI.b(this.pcc, true);
                WalletLqtSaveFetchUI.a(this.pcc, true);
            } else {
                WalletLqtSaveFetchUI.l(this.pcc).setText(this.pcc.getString(i.wallet_lqt_save_exceed_bankcard_limit));
                WalletLqtSaveFetchUI.l(this.pcc).setTextColor(-65536);
                WalletLqtSaveFetchUI.b(this.pcc, false);
                WalletLqtSaveFetchUI.a(this.pcc, false);
            }
        } else if (WalletLqtSaveFetchUI.g(this.pcc) == 2) {
            boolean z;
            if (WalletLqtSaveFetchUI.d(this.pcc) == null || !WalletLqtSaveFetchUI.d(this.pcc).bOs()) {
                awx awx = l.bMQ().oZa;
                if (awx == null) {
                    length = 0;
                    z = false;
                } else {
                    length = awx.rZW;
                    z = false;
                }
            } else {
                length = this.pcc.getIntent().getIntExtra("lqt_balance", 0);
                z = true;
            }
            if (fb > length) {
                if (z) {
                    WalletLqtSaveFetchUI.l(this.pcc).setText(this.pcc.getString(i.wallet_lqt_fetch_balance_not_enough_hint));
                } else {
                    WalletLqtSaveFetchUI.l(this.pcc).setText(this.pcc.getString(i.wallet_lqt_fetch_bankcard_money_not_enough_hint));
                }
                WalletLqtSaveFetchUI.l(this.pcc).setTextColor(-65536);
                WalletLqtSaveFetchUI.b(this.pcc, false);
                WalletLqtSaveFetchUI.a(this.pcc, false);
            } else if (WalletLqtSaveFetchUI.n(this.pcc) > 0 && fb > WalletLqtSaveFetchUI.n(this.pcc)) {
                WalletLqtSaveFetchUI.l(this.pcc).setText(WalletLqtSaveFetchUI.o(this.pcc));
                WalletLqtSaveFetchUI.l(this.pcc).setTextColor(-65536);
                WalletLqtSaveFetchUI.b(this.pcc, false);
                WalletLqtSaveFetchUI.a(this.pcc, false);
            } else if (WalletLqtSaveFetchUI.d(this.pcc) == null || WalletLqtSaveFetchUI.d(this.pcc).bOs() || WalletLqtSaveFetchUI.d(this.pcc).field_dayQuotaKind <= 0.0d || fb <= WalletLqtSaveFetchUI.fb(WalletLqtSaveFetchUI.d(this.pcc).field_dayQuotaKind, "100")) {
                WalletLqtSaveFetchUI.l(this.pcc).setText(WalletLqtSaveFetchUI.m(this.pcc));
                WalletLqtSaveFetchUI.l(this.pcc).setTextColor(Color.parseColor("#888888"));
                WalletLqtSaveFetchUI.b(this.pcc, true);
                WalletLqtSaveFetchUI.a(this.pcc, true);
            } else {
                WalletLqtSaveFetchUI.l(this.pcc).setText(this.pcc.getString(i.wallet_lqt_fetch_exceed_bankcard_limit));
                WalletLqtSaveFetchUI.l(this.pcc).setTextColor(-65536);
                WalletLqtSaveFetchUI.b(this.pcc, false);
                WalletLqtSaveFetchUI.a(this.pcc, false);
            }
        }
    }
}
