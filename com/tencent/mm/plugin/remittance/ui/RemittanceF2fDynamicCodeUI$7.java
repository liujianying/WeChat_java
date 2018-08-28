package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

class RemittanceF2fDynamicCodeUI$7 implements d {
    final /* synthetic */ RemittanceF2fDynamicCodeUI mCI;

    RemittanceF2fDynamicCodeUI$7(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        this.mCI = remittanceF2fDynamicCodeUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (i == 0) {
            RemittanceF2fDynamicCodeUI.a(this.mCI, 1);
        }
    }
}
