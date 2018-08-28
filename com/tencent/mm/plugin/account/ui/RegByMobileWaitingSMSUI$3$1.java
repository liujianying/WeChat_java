package com.tencent.mm.plugin.account.ui;

import android.os.Build.VERSION;
import com.tencent.mm.plugin.account.ui.RegByMobileWaitingSMSUI.3;

class RegByMobileWaitingSMSUI$3$1 implements Runnable {
    final /* synthetic */ 3 eWb;

    RegByMobileWaitingSMSUI$3$1(3 3) {
        this.eWb = 3;
    }

    public final void run() {
        if (VERSION.SDK_INT >= 8) {
            RegByMobileWaitingSMSUI.f(this.eWb.eWa).smoothScrollToPosition(RegByMobileWaitingSMSUI.e(this.eWb.eWa).getCount() - 1);
        } else {
            RegByMobileWaitingSMSUI.f(this.eWb.eWa).setSelection(RegByMobileWaitingSMSUI.e(this.eWb.eWa).getCount() - 1);
        }
    }
}
