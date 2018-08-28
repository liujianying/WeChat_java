package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.bi;

class BindMContactUI$2 implements a {
    final /* synthetic */ BindMContactUI eGA;
    String eGB;

    BindMContactUI$2(BindMContactUI bindMContactUI) {
        this.eGA = bindMContactUI;
    }

    public final boolean Ks() {
        if (bi.oW((BindMContactUI.b(this.eGA).getText()).trim())) {
            if (bi.oW(this.eGB)) {
                BindMContactUI.b(this.eGA).setText("");
            } else {
                BindMContactUI.b(this.eGA).setText(this.eGB);
                BindMContactUI.b(this.eGA).setSelection(this.eGB.length());
            }
        }
        return true;
    }

    public final boolean Kr() {
        this.eGB = ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getPhoneNum(this.eGA, BindMContactUI.c(this.eGA));
        return true;
    }

    public final String toString() {
        return super.toString() + "|initView";
    }
}
