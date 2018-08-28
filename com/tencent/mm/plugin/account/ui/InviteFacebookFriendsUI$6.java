package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.sdk.platformtools.al.a;

class InviteFacebookFriendsUI$6 implements a {
    final /* synthetic */ InviteFacebookFriendsUI eQB;
    final /* synthetic */ ab eQo;

    InviteFacebookFriendsUI$6(InviteFacebookFriendsUI inviteFacebookFriendsUI, ab abVar) {
        this.eQB = inviteFacebookFriendsUI;
        this.eQo = abVar;
    }

    public final boolean vD() {
        g.Ei().DT().set(65829, Integer.valueOf(1));
        g.DF().a(this.eQo, 0);
        return false;
    }
}
