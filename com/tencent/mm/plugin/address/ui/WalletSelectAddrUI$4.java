package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.plugin.address.model.g;
import com.tencent.mm.sdk.platformtools.x;

class WalletSelectAddrUI$4 implements OnItemClickListener {
    final /* synthetic */ WalletSelectAddrUI fae;

    WalletSelectAddrUI$4(WalletSelectAddrUI walletSelectAddrUI) {
        this.fae = walletSelectAddrUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.WalletSelectAddrUI", "select pos " + i);
        synchronized (WalletSelectAddrUI.c(this.fae)) {
            if (i < WalletSelectAddrUI.d(this.fae).size()) {
                WalletSelectAddrUI.a(this.fae, (b) WalletSelectAddrUI.d(this.fae).get(i));
                if (!WalletSelectAddrUI.e(this.fae) && WalletSelectAddrUI.f(this.fae) != null) {
                    WalletSelectAddrUI.a(this.fae, WalletSelectAddrUI.f(this.fae).id);
                } else if (!(WalletSelectAddrUI.f(this.fae) == null || WalletSelectAddrUI.f(this.fae).id == 0)) {
                    WalletSelectAddrUI.g(this.fae).g(new g(WalletSelectAddrUI.f(this.fae).id));
                }
            }
        }
        WalletSelectAddrUI.h(this.fae).notifyDataSetChanged();
    }
}
