package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.x;

class WalletPasswordSettingUI$7 implements OnClickListener {
    final /* synthetic */ WalletPasswordSettingUI pif;
    final /* synthetic */ k pii;

    WalletPasswordSettingUI$7(WalletPasswordSettingUI walletPasswordSettingUI, k kVar) {
        this.pif = walletPasswordSettingUI;
        this.pii = kVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.WalletPasswordSettingUI", "user click the button to set system fingerprint");
        this.pii.di(this.pif);
    }
}
