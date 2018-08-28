package com.tencent.mm.plugin.address.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class WalletAddAddressUI$4 implements OnClickListener {
    final /* synthetic */ WalletAddAddressUI eZQ;

    WalletAddAddressUI$4(WalletAddAddressUI walletAddAddressUI) {
        this.eZQ = walletAddAddressUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.eZQ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
