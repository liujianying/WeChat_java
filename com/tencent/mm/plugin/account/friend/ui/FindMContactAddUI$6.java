package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.x;

class FindMContactAddUI$6 implements a {
    final /* synthetic */ FindMContactAddUI eLW;

    FindMContactAddUI$6(FindMContactAddUI findMContactAddUI) {
        this.eLW = findMContactAddUI;
    }

    public final boolean Ks() {
        if (FindMContactAddUI.a(this.eLW) != null) {
            FindMContactAddUI.a(this.eLW).dismiss();
            FindMContactAddUI.b(this.eLW);
        }
        FindMContactAddUI.c(this.eLW).notifyDataSetChanged();
        return false;
    }

    public final boolean Kr() {
        try {
            FindMContactAddUI.a(this.eLW, com.tencent.mm.pluginsdk.a.cz(this.eLW));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FindMContactAddUI", e, "", new Object[0]);
        }
        FindMContactAddUI.c(this.eLW).eHv = FindMContactAddUI.d(this.eLW);
        FindMContactAddUI.c(this.eLW).p(((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
        return true;
    }

    public final String toString() {
        return super.toString() + "|listMFriendData";
    }
}
