package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;

class RegSetInfoUI$1 implements a {
    final /* synthetic */ RegSetInfoUI eWJ;

    RegSetInfoUI$1(RegSetInfoUI regSetInfoUI) {
        this.eWJ = regSetInfoUI;
    }

    public final boolean vD() {
        String str;
        String trim = RegSetInfoUI.a(this.eWJ).getText().toString().trim();
        String trim2 = RegSetInfoUI.b(this.eWJ).getText().toString().trim();
        if (bi.oW(trim) && !bi.oW(trim2)) {
            trim = trim2.length() > 5 ? trim2.substring(0, 5) : trim2;
        }
        if (bi.oW(trim) || !bi.oW(trim2)) {
            str = trim2;
        } else {
            str = trim;
        }
        if (!bi.oW(trim) && RegSetInfoUI.c(this.eWJ) && RegSetInfoUI.d(this.eWJ)) {
            int e = RegSetInfoUI.e(this.eWJ);
            String f = RegSetInfoUI.f(this.eWJ);
            g.DF().a(429, this.eWJ);
            g.DF().a(new ad(f, RegSetInfoUI.g(this.eWJ), e, str, trim, "", ""), 0);
            RegSetInfoUI.h(this.eWJ).setVisibility(0);
        }
        return false;
    }
}
