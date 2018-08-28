package com.tencent.mm.ui.contact;

import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.sdk.platformtools.ah;

class MMBaseSelectContactUI$7 implements Runnable {
    final /* synthetic */ MMBaseSelectContactUI ukl;

    MMBaseSelectContactUI$7(MMBaseSelectContactUI mMBaseSelectContactUI) {
        this.ukl = mMBaseSelectContactUI;
    }

    public final void run() {
        MMBaseSelectContactUI.a(this.ukl, a.aYK().aYF());
        MMBaseSelectContactUI.j(this.ukl);
        ah.A(new 1(this));
    }

    public final String toString() {
        return super.toString() + "|updateLabelList";
    }
}
