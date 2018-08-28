package com.tencent.mm.ui.contact;

import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a;

class SnsAddressUI$3 implements a {
    final /* synthetic */ SnsAddressUI ulS;

    SnsAddressUI$3(SnsAddressUI snsAddressUI) {
        this.ulS = snsAddressUI;
    }

    public final void pf(String str) {
        if (str != null) {
            SnsAddressUI.a(this.ulS).remove(str);
            SnsAddressUI.b(this.ulS);
        }
    }
}
