package com.tencent.mm.plugin.wallet.pay.ui;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.h.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class WalletPayDeductUI$3 implements a {
    final /* synthetic */ WalletPayDeductUI pgf;
    final /* synthetic */ List pgg;

    WalletPayDeductUI$3(WalletPayDeductUI walletPayDeductUI, List list) {
        this.pgf = walletPayDeductUI;
        this.pgg = list;
    }

    public final void onClick(View view) {
        int i = 0;
        ActionBarActivity actionBarActivity = this.pgf.mController.tml;
        List list = this.pgg;
        String a = WalletPayDeductUI.a(this.pgf);
        Bankcard b = WalletPayDeductUI.b(this.pgf);
        1 1 = new 1(this);
        List linkedList = new LinkedList();
        if ((list == null || list.size() == 0) && bi.oW(null)) {
            x.w("MicroMsg.WalletDialogHelper", "hy: bankcard list is null and should not show new");
            return;
        }
        int i2;
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.WalletDialogHelper", "hy: no bankcard show new only");
            linkedList.add(null);
            i2 = 0;
        } else {
            Iterator it = list.iterator();
            int i3 = 0;
            while (true) {
                i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                Bankcard bankcard = (Bankcard) it.next();
                linkedList.add(bankcard.field_desc);
                if (b != null && b.equals(bankcard)) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (!bi.oW(null)) {
                linkedList.add(null);
                if (b == null) {
                    i2 = i3;
                }
            }
        }
        h.a(actionBarActivity, a, linkedList, i2, 1);
    }
}
