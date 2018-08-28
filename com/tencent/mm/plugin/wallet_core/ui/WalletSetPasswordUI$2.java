package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

class WalletSetPasswordUI$2 implements a {
    final /* synthetic */ WalletSetPasswordUI pys;

    WalletSetPasswordUI$2(WalletSetPasswordUI walletSetPasswordUI) {
        this.pys = walletSetPasswordUI;
    }

    public final void fE(boolean z) {
        if (z) {
            String md5Value = this.pys.kkY.getMd5Value();
            Bundle bundle = new Bundle();
            bundle.putString("key_new_pwd1", md5Value);
            this.pys.kkY.bqn();
            com.tencent.mm.wallet_core.a.j(this.pys, bundle);
        }
    }
}
