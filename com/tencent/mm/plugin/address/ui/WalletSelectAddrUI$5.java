package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.plugin.address.model.f;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

class WalletSelectAddrUI$5 implements OnItemLongClickListener {
    final /* synthetic */ WalletSelectAddrUI fae;

    WalletSelectAddrUI$5(WalletSelectAddrUI walletSelectAddrUI) {
        this.fae = walletSelectAddrUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
        h.a(this.fae.mController.tml, null, this.fae.getResources().getStringArray(R.c.wallet_address_opt_list), null, new c() {
            public final void ju(int i) {
                b bVar;
                synchronized (WalletSelectAddrUI.c(WalletSelectAddrUI$5.this.fae)) {
                    if (i < WalletSelectAddrUI.d(WalletSelectAddrUI$5.this.fae).size()) {
                        bVar = (b) WalletSelectAddrUI.d(WalletSelectAddrUI$5.this.fae).get(i);
                    } else {
                        bVar = null;
                    }
                }
                if (bVar != null) {
                    switch (i) {
                        case 0:
                            WalletSelectAddrUI.a(WalletSelectAddrUI$5.this.fae, bVar.id);
                            return;
                        case 1:
                            f fVar = new f(bVar.id);
                            WalletSelectAddrUI.a(WalletSelectAddrUI$5.this.fae, null);
                            WalletSelectAddrUI.g(WalletSelectAddrUI$5.this.fae).g(fVar);
                            return;
                        case 2:
                            WalletSelectAddrUI.b(WalletSelectAddrUI$5.this.fae, bVar);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        return true;
    }
}
