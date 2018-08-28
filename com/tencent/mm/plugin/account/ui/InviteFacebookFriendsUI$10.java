package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.f.a.c;

class InviteFacebookFriendsUI$10 implements OnMenuItemClickListener {
    final /* synthetic */ InviteFacebookFriendsUI eQB;

    InviteFacebookFriendsUI$10(InviteFacebookFriendsUI inviteFacebookFriendsUI) {
        this.eQB = inviteFacebookFriendsUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        c cVar = new c("290293790992170");
        Bundle bundle = new Bundle();
        bundle.putString("message", this.eQB.getString(q$e.facebook_invite_message));
        long[] Yx = InviteFacebookFriendsUI.a(this.eQB).Yx();
        String l = Long.toString(Yx[0]);
        for (int i = 1; i < Yx.length; i++) {
            l = (l + ",") + Long.toString(Yx[i]);
        }
        bundle.putString("to", l);
        cVar.a(this.eQB, "apprequests", bundle, new 1(this, Yx));
        return true;
    }
}
