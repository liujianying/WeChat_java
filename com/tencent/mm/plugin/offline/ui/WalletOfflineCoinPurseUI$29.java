package com.tencent.mm.plugin.offline.ui;

import android.text.TextUtils;
import android.view.MenuItem;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

class WalletOfflineCoinPurseUI$29 implements d {
    final /* synthetic */ com.tencent.mm.ui.widget.a.d eRB;
    final /* synthetic */ List kkU;
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$29(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, com.tencent.mm.ui.widget.a.d dVar, List list) {
        this.lMe = walletOfflineCoinPurseUI;
        this.eRB = dVar;
        this.kkU = list;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (this.eRB != null) {
            this.eRB.bzW();
            Bankcard bankcard = (Bankcard) this.kkU.get(i);
            h.mEJ.h(14515, new Object[]{Integer.valueOf(3)});
            if (!(bi.oW(bankcard.field_forbid_title) && bi.oW(bankcard.field_forbidWord) && bankcard.field_support_micropay)) {
                h.mEJ.h(14515, new Object[]{Integer.valueOf(4)});
            }
            String str = bankcard.field_bindSerial;
            if (!TextUtils.isEmpty(str) && !str.equals(WalletOfflineCoinPurseUI.D(this.lMe))) {
                WalletOfflineCoinPurseUI.a(this.lMe, str);
                a.Ja(WalletOfflineCoinPurseUI.D(this.lMe));
                k.bkO();
                k.bkQ().lIF = WalletOfflineCoinPurseUI.D(this.lMe);
                this.lMe.blo();
                WalletOfflineCoinPurseUI.E(this.lMe);
                WalletOfflineCoinPurseUI.F(this.lMe);
            }
        }
    }
}
