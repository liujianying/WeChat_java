package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.23;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class BindMContactIntroUI$23$1 implements c {
    final /* synthetic */ 23 eGi;

    BindMContactIntroUI$23$1(23 23) {
        this.eGi = 23;
    }

    public final void a(l lVar) {
        lVar.setHeaderTitle(j.bind_mcontact_list_menu_title);
        if ((this.eGi.eGh & 2) != 0) {
            lVar.eR(0, j.bind_mcontact_unbind_mobile_text);
        }
        if ((this.eGi.eGh & 1) != 0) {
            lVar.eR(1, j.bind_mcontact_change_privacy);
        }
    }
}
