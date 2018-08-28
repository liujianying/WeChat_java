package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.12;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.e;

class BankRemitBankcardInputUI$12$2 implements d {
    final /* synthetic */ 12 mvj;

    BankRemitBankcardInputUI$12$2(12 12) {
        this.mvj = 12;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                if (bi.oW(BankRemitBankcardInputUI.b(this.mvj.mve))) {
                    x.w("MicroMsg.BankRemitBankcardInputUI", "paylist url is null");
                } else {
                    e.l(this.mvj.mve.mController.tml, BankRemitBankcardInputUI.b(this.mvj.mve), false);
                }
                h.mEJ.h(14673, new Object[]{Integer.valueOf(6)});
                return;
            case 1:
                e.l(this.mvj.mve.mController.tml, "https://kf.qq.com/touch/scene_product.html?scene_id=kf4568", true);
                return;
            default:
                return;
        }
    }
}
