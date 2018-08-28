package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.tools.a.c;

class RegByMobileRegAIOUI$2 implements OnClickListener {
    final /* synthetic */ RegByMobileRegAIOUI eVb;

    RegByMobileRegAIOUI$2(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        this.eVb = regByMobileRegAIOUI;
    }

    public final void onClick(View view) {
        c fj = c.d(RegByMobileRegAIOUI.i(this.eVb).getContentEditText()).fj(1, 32);
        fj.uCR = true;
        fj.a(new 1(this));
    }
}
