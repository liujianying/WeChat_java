package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class RemittanceF2fDynamicCodeUI$a implements a {
    final /* synthetic */ RemittanceF2fDynamicCodeUI mCI;

    private RemittanceF2fDynamicCodeUI$a(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        this.mCI = remittanceF2fDynamicCodeUI;
    }

    /* synthetic */ RemittanceF2fDynamicCodeUI$a(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI, byte b) {
        this(remittanceF2fDynamicCodeUI);
    }

    public final boolean vD() {
        x.d("MicroMsg.RemittanceF2fDynamicCodeUI", "timer expired");
        if (!RemittanceF2fDynamicCodeUI.e(this.mCI)) {
            RemittanceF2fDynamicCodeUI.a(this.mCI, System.currentTimeMillis());
            RemittanceF2fDynamicCodeUI.f(this.mCI);
        }
        return true;
    }
}
