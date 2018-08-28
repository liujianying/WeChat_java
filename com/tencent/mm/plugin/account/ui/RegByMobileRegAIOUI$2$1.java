package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.al.b;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.2;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.c.a;

class RegByMobileRegAIOUI$2$1 implements a {
    final /* synthetic */ 2 eVc;

    RegByMobileRegAIOUI$2$1(2 2) {
        this.eVc = 2;
    }

    public final void pO(String str) {
        RegByMobileRegAIOUI.a(this.eVc.eVb, ap.Ww(RegByMobileRegAIOUI.c(this.eVc.eVb).getText().toString()));
        RegByMobileRegAIOUI.b(this.eVc.eVb, ap.Wy(RegByMobileRegAIOUI.d(this.eVc.eVb)));
        String str2 = RegByMobileRegAIOUI.e(this.eVc.eVb) + RegByMobileRegAIOUI.f(this.eVc.eVb);
        this.eVc.eVb.YC();
        if (RegByMobileRegAIOUI.g(this.eVc.eVb)) {
            if (bi.oW(RegByMobileRegAIOUI.h(this.eVc.eVb))) {
                RegByMobileRegAIOUI.c(this.eVc.eVb, b.l(this.eVc.eVb, RegByMobileRegAIOUI.d(this.eVc.eVb), this.eVc.eVb.getString(a$j.country_code)));
            }
            com.tencent.mm.platformtools.a.b(this.eVc.eVb, this.eVc.eVb.getString(a$j.license_read_url, new Object[]{w.chP(), RegByMobileRegAIOUI.h(this.eVc.eVb), "reg", Integer.valueOf(1), Integer.valueOf(0)}), 30847, false);
            return;
        }
        RegByMobileRegAIOUI.d(this.eVc.eVb, str2);
    }

    public final void YX() {
        h.i(this.eVc.eVb, a$j.settings_modify_name_invalid_less, a$j.settings_modify_name_title);
    }

    public final void YY() {
        h.i(this.eVc.eVb, a$j.settings_modify_name_invalid_more, a$j.settings_modify_name_title);
    }
}
