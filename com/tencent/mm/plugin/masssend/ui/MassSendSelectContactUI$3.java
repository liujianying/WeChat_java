package com.tencent.mm.plugin.masssend.ui;

import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a;

class MassSendSelectContactUI$3 implements a {
    final /* synthetic */ MassSendSelectContactUI lbx;

    MassSendSelectContactUI$3(MassSendSelectContactUI massSendSelectContactUI) {
        this.lbx = massSendSelectContactUI;
    }

    public final void pf(String str) {
        if (str != null) {
            MassSendSelectContactUI.a(this.lbx).remove(str);
            MassSendSelectContactUI.a(this.lbx, MassSendSelectContactUI.a(this.lbx).size());
        }
    }
}
