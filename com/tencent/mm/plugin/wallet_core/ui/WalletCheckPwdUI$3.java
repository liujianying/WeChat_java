package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

class WalletCheckPwdUI$3 implements a {
    final /* synthetic */ WalletCheckPwdUI pvi;

    WalletCheckPwdUI$3(WalletCheckPwdUI walletCheckPwdUI) {
        this.pvi = walletCheckPwdUI;
    }

    public final void fE(boolean z) {
        if (z) {
            WalletCheckPwdUI.a(this.pvi, this.pvi.kkY.getText());
            c af = com.tencent.mm.wallet_core.a.af(this.pvi);
            Object obj = null;
            if (af != null) {
                obj = af.aNK();
            }
            if (!WalletCheckPwdUI.b(this.pvi) || "UnbindProcess".equals(obj)) {
                if (!this.pvi.cDL().m(new Object[]{WalletCheckPwdUI.c(this.pvi), this.pvi.bNs()})) {
                    this.pvi.a(new r(WalletCheckPwdUI.c(this.pvi), 1, this.pvi.bNs()), true, true);
                    return;
                }
                return;
            }
            this.pvi.a(new s(WalletCheckPwdUI.c(this.pvi), WalletCheckPwdUI.d(this.pvi), (byte) 0), true, true);
            h.mEJ.h(15021, new Object[]{Integer.valueOf(1)});
        }
    }
}
