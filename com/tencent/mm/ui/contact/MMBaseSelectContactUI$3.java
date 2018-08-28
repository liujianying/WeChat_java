package com.tencent.mm.ui.contact;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.m.a;

class MMBaseSelectContactUI$3 implements a {
    final /* synthetic */ MMBaseSelectContactUI ukl;

    MMBaseSelectContactUI$3(MMBaseSelectContactUI mMBaseSelectContactUI) {
        this.ukl = mMBaseSelectContactUI;
    }

    public final void q(String str, int i, boolean z) {
        x.i("MicroMsg.MMBaseSelectContactUI", "Callback SearchEnd Count=%d", new Object[]{Integer.valueOf(i)});
        if (!z || i != 0) {
            MMBaseSelectContactUI.c(this.ukl);
        } else if (bi.oW(str)) {
            MMBaseSelectContactUI.a(this.ukl);
        } else {
            MMBaseSelectContactUI.b(this.ukl);
        }
    }
}
