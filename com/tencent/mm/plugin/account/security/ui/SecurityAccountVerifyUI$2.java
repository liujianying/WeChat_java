package com.tencent.mm.plugin.account.security.ui;

import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.al.a;

class SecurityAccountVerifyUI$2 implements a {
    final /* synthetic */ SecurityAccountVerifyUI ePi;

    SecurityAccountVerifyUI$2(SecurityAccountVerifyUI securityAccountVerifyUI) {
        this.ePi = securityAccountVerifyUI;
    }

    public final boolean vD() {
        int intValue = ((Integer) SecurityAccountVerifyUI.a(this.ePi).getTag()).intValue();
        if (intValue <= 1) {
            SecurityAccountVerifyUI.b(this.ePi).setVisibility(0);
            SecurityAccountVerifyUI.a(this.ePi).setVisibility(8);
            return false;
        }
        SecurityAccountVerifyUI.a(this.ePi).setTag(Integer.valueOf(intValue - 1));
        SecurityAccountVerifyUI.a(this.ePi).setText(this.ePi.getString(j.safe_device_resend_verify_code_tips, new Object[]{Integer.valueOf(intValue)}));
        if (SecurityAccountVerifyUI.a(this.ePi).getVisibility() != 0) {
            SecurityAccountVerifyUI.a(this.ePi).setVisibility(0);
        }
        return true;
    }
}
