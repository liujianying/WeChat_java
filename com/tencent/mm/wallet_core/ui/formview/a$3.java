package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.formview.a.b;

class a$3 extends b {
    a$3() {
        super((byte) 0);
    }

    public final boolean bqk() {
        return true;
    }

    public final String e(WalletFormView walletFormView, String str) {
        return bi.aG((String) walletFormView.getTag(), "").replace("/", "");
    }
}
