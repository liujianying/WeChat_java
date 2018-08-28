package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.plugin.account.ui.d.a;

class FacebookFriendUI$6 implements a {
    final /* synthetic */ FacebookFriendUI eQm;

    FacebookFriendUI$6(FacebookFriendUI facebookFriendUI) {
        this.eQm = facebookFriendUI;
    }

    public final void ja(int i) {
        if (i > 0) {
            FacebookFriendUI.d(this.eQm).setVisibility(8);
        } else {
            FacebookFriendUI.d(this.eQm).setVisibility(0);
        }
    }
}
