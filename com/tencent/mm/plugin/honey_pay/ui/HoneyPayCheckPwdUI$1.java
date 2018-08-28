package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

class HoneyPayCheckPwdUI$1 implements a {
    final /* synthetic */ HoneyPayCheckPwdUI kld;

    HoneyPayCheckPwdUI$1(HoneyPayCheckPwdUI honeyPayCheckPwdUI) {
        this.kld = honeyPayCheckPwdUI;
    }

    public final void fE(boolean z) {
        if (z) {
            if (HoneyPayCheckPwdUI.a(this.kld) == 1) {
                HoneyPayCheckPwdUI.b(this.kld);
            } else if (HoneyPayCheckPwdUI.a(this.kld) == 2) {
                HoneyPayCheckPwdUI.c(this.kld);
            } else if (HoneyPayCheckPwdUI.a(this.kld) == 3) {
                HoneyPayCheckPwdUI.d(this.kld);
            } else {
                x.w("MicroMsg.HoneyPayCheckPwdUI", "unknown scene: %s", new Object[]{Integer.valueOf(HoneyPayCheckPwdUI.a(this.kld))});
            }
            this.kld.Wq();
        }
    }
}
