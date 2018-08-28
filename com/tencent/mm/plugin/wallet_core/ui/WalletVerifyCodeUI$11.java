package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

class WalletVerifyCodeUI$11 implements OnMenuItemClickListener {
    final /* synthetic */ WalletVerifyCodeUI pyT;

    WalletVerifyCodeUI$11(WalletVerifyCodeUI walletVerifyCodeUI) {
        this.pyT = walletVerifyCodeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String string = this.pyT.sy.getString("key_QADNA_URL");
        if (bi.oW(string)) {
            e.l(this.pyT.mController.tml, "https://kf.qq.com/touch/sappfaq/160830qY7NJJ1608307ZJzqy.html", false);
        } else {
            e.l(this.pyT.mController.tml, string, false);
        }
        return true;
    }
}
