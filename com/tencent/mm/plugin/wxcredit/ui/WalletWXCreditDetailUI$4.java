package com.tencent.mm.plugin.wxcredit.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import java.util.ArrayList;
import java.util.List;

class WalletWXCreditDetailUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ WalletWXCreditDetailUI qxp;

    WalletWXCreditDetailUI$4(WalletWXCreditDetailUI walletWXCreditDetailUI) {
        this.qxp = walletWXCreditDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        List arrayList = new ArrayList();
        o.bOW();
        String str = WalletWXCreditDetailUI.a(this.qxp).field_bindSerial;
        h.a(this.qxp, null, (String[]) arrayList.toArray(new String[arrayList.size()]), this.qxp.getString(i.wallet_index_ui_unbind_bankcard), false, new c() {
            public final void ju(int i) {
                switch (i) {
                    case 0:
                        o.bOW();
                        String str = WalletWXCreditDetailUI.a(WalletWXCreditDetailUI$4.this.qxp).field_bindSerial;
                        WalletWXCreditDetailUI.cbd();
                        return;
                    case 1:
                        WalletWXCreditDetailUI.c(WalletWXCreditDetailUI$4.this.qxp);
                        return;
                    default:
                        return;
                }
            }
        });
        return true;
    }
}
