package com.tencent.mm.plugin.sport.ui;

import android.content.Intent;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;

class SportBlackListUI$2 implements a {
    final /* synthetic */ SportBlackListUI opx;

    SportBlackListUI$2(SportBlackListUI sportBlackListUI) {
        this.opx = sportBlackListUI;
    }

    public final void of(int i) {
        String Cc = SportBlackListUI.a(this.opx).Cc(i);
        SportBlackListUI.b(this.opx).remove(Cc);
        SportBlackListUI.a(this.opx).p(null, SportBlackListUI.b(this.opx));
        SportBlackListUI.a(this.opx).refresh();
        au.HU();
        s.g(c.FR().Yg(Cc));
        d.kB(40);
    }

    public final void oh(int i) {
        SportBlackListUI.c(this.opx);
    }

    public final void og(int i) {
        String Cc = SportBlackListUI.a(this.opx).Cc(i);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", Cc);
        com.tencent.mm.bg.d.b(this.opx, "profile", ".ui.ContactInfoUI", intent);
    }

    public final void aAK() {
        SportBlackListUI.a(this.opx).cdV();
    }
}
