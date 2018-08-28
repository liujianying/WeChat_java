package com.tencent.mm.wallet_core.ui.formview;

import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.formview.a.b;

class a$1 extends b {
    a$1() {
        super((byte) 0);
    }

    public final boolean c(WalletFormView walletFormView, String str) {
        if (bi.oW(str) || str.length() > 5) {
            return false;
        }
        walletFormView.setSelection(0);
        walletFormView.setBankcardTail(str);
        walletFormView.setMaxInputLength(24 - str.length());
        walletFormView.setFilters(new InputFilter[]{new LengthFilter(walletFormView.getMaxInputLength())});
        return true;
    }

    public final boolean d(WalletFormView walletFormView, String str) {
        if (bi.oW(str) || str.length() > 5) {
            return false;
        }
        walletFormView.setSelection(0);
        walletFormView.set3DesToView(str);
        walletFormView.setMaxInputLength(24 - str.length());
        walletFormView.setFilters(new InputFilter[]{new LengthFilter(walletFormView.getMaxInputLength())});
        return true;
    }

    public final boolean a(WalletFormView walletFormView) {
        return walletFormView.uZy == null ? false : walletFormView.uZy.isBankcardNum();
    }

    public final boolean bqk() {
        return true;
    }

    public final String e(WalletFormView walletFormView, String str) {
        return bi.aG(str, "").replaceAll(" ", "");
    }
}
