package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.x;

class FindMContactIntroUI$11 implements a {
    final /* synthetic */ FindMContactIntroUI eHN;

    FindMContactIntroUI$11(FindMContactIntroUI findMContactIntroUI) {
        this.eHN = findMContactIntroUI;
    }

    public final boolean Ks() {
        if (FindMContactIntroUI.k(this.eHN) == null || FindMContactIntroUI.k(this.eHN).size() == 0) {
            if (FindMContactIntroUI.g(this.eHN) != null) {
                FindMContactIntroUI.g(this.eHN).dismiss();
                FindMContactIntroUI.h(this.eHN);
            }
            FindMContactIntroUI.b(this.eHN);
        } else {
            FindMContactIntroUI.a(this.eHN, new ag(FindMContactIntroUI.c(this.eHN), FindMContactIntroUI.k(this.eHN)));
            g.DF().a(FindMContactIntroUI.l(this.eHN), 0);
        }
        return false;
    }

    public final boolean Kr() {
        try {
            FindMContactIntroUI.a(this.eHN, com.tencent.mm.pluginsdk.a.cz(this.eHN));
            x.d("MicroMsg.FindMContactIntroUI", "tigerreg mobileList size " + (FindMContactIntroUI.k(this.eHN) == null ? 0 : FindMContactIntroUI.k(this.eHN).size()));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FindMContactIntroUI", e, "", new Object[0]);
        }
        return true;
    }

    public final String toString() {
        return super.toString() + "|doUpload";
    }
}
