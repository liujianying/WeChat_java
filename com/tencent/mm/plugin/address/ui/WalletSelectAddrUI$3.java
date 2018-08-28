package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class WalletSelectAddrUI$3 implements OnClickListener {
    final /* synthetic */ WalletSelectAddrUI fae;

    WalletSelectAddrUI$3(WalletSelectAddrUI walletSelectAddrUI) {
        this.fae = walletSelectAddrUI;
    }

    public final void onClick(View view) {
        h.a(this.fae, true, this.fae.getString(R.l.addressui_mall_address_import_confirm, new Object[]{WalletSelectAddrUI.a(this.fae).toString()}), "", this.fae.getString(R.l.addressui_mall_address_import_confirm_ok), this.fae.getString(R.l.app_cancel), new 1(this), null);
    }
}
