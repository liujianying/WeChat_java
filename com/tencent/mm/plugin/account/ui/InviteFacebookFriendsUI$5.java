package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.account.model.h;

class InviteFacebookFriendsUI$5 extends h {
    final /* synthetic */ InviteFacebookFriendsUI eQB;

    InviteFacebookFriendsUI$5(InviteFacebookFriendsUI inviteFacebookFriendsUI) {
        this.eQB = inviteFacebookFriendsUI;
    }

    public final void m(Bundle bundle) {
        super.m(bundle);
    }

    public final void onError(int i, String str) {
        super.onError(i, str);
        if (i == 3) {
            InviteFacebookFriendsUI.c(this.eQB);
        }
    }
}
