package com.tencent.mm.plugin.address.ui;

import com.tencent.mm.plugin.address.ui.AddrEditView.a;
import com.tencent.mm.sdk.platformtools.x;

class WalletAddAddressUI$8 implements a {
    final /* synthetic */ WalletAddAddressUI eZQ;

    WalletAddAddressUI$8(WalletAddAddressUI walletAddAddressUI) {
        this.eZQ = walletAddAddressUI;
    }

    public final void onClick() {
        x.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.eZQ, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
        if (com.tencent.mm.pluginsdk.permission.a.a(this.eZQ, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
            WalletAddAddressUI.b(this.eZQ);
        }
    }
}
