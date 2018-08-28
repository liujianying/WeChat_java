package com.tencent.mm.plugin.address.ui;

import com.tencent.mm.plugin.address.ui.AddrEditView.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WalletAddAddressUI$1 implements a {
    final /* synthetic */ WalletAddAddressUI eZQ;

    WalletAddAddressUI$1(WalletAddAddressUI walletAddAddressUI) {
        this.eZQ = walletAddAddressUI;
    }

    public final void onClick() {
        x.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.eZQ, "android.permission.READ_CONTACTS", 48, null, null)), bi.cjd()});
        if (com.tencent.mm.pluginsdk.permission.a.a(this.eZQ, "android.permission.READ_CONTACTS", 48, null, null)) {
            WalletAddAddressUI.a(this.eZQ);
        }
    }
}
