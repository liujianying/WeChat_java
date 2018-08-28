package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.g.a.tw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class RemittanceOSUI$1 extends c<tw> {
    final /* synthetic */ RemittanceOSUI mCX;

    RemittanceOSUI$1(RemittanceOSUI remittanceOSUI) {
        this.mCX = remittanceOSUI;
        this.sFo = tw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (RemittanceOSUI.a(this.mCX)) {
            this.mCX.finish();
        }
        return false;
    }
}
