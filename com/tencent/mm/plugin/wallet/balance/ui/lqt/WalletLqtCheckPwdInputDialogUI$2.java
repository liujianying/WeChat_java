package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.o.c;

class WalletLqtCheckPwdInputDialogUI$2 implements c {
    final /* synthetic */ WalletLqtCheckPwdInputDialogUI paT;

    WalletLqtCheckPwdInputDialogUI$2(WalletLqtCheckPwdInputDialogUI walletLqtCheckPwdInputDialogUI) {
        this.paT = walletLqtCheckPwdInputDialogUI;
    }

    public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
        WalletLqtCheckPwdInputDialogUI.a(this.paT).dismiss();
        Intent intent = new Intent();
        intent.putExtra("lqt_fetch_enc_pwd", str);
        this.paT.setResult(-1, intent);
        this.paT.finish();
    }
}
