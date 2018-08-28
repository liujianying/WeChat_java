package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.platformtools.j;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;

class RegByMobileRegAIOUI$3 implements a {
    String eGB;
    final /* synthetic */ RegByMobileRegAIOUI eVb;

    RegByMobileRegAIOUI$3(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        this.eVb = regByMobileRegAIOUI;
    }

    public final boolean Ks() {
        if (bi.oW((RegByMobileRegAIOUI.c(this.eVb).getText()).trim())) {
            String Fp = ap.Fp(this.eGB);
            if (!bi.oW(this.eGB) && "+86".equals(Fp)) {
                RegByMobileRegAIOUI.c(this.eVb).setText(this.eGB.substring(3));
            }
        }
        return true;
    }

    public final boolean Kr() {
        this.eGB = j.getPhoneNum(this.eVb, RegByMobileRegAIOUI.d(this.eVb));
        return true;
    }

    public final String toString() {
        return super.toString() + "|initView1";
    }
}
